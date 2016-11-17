package ar.fiuba.tdd.grupo04;

import com.google.gson.Gson;

import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.board.Slot;
import ar.fiuba.tdd.grupo04.json.game.BoardMapper;
import ar.fiuba.tdd.grupo04.json.game.GameMapper;
import ar.fiuba.tdd.grupo04.json.game.StructureMapper;
import ar.fiuba.tdd.grupo04.json.scenario.CellMapper;
import ar.fiuba.tdd.grupo04.json.scenario.ScenarioMapper;
import ar.fiuba.tdd.grupo04.json.scenario.SlotMapper;
import ar.fiuba.tdd.grupo04.neighborhood.DiagonalNeighborhood;
import ar.fiuba.tdd.grupo04.neighborhood.Neighborhood;
import ar.fiuba.tdd.grupo04.neighborhood.StraightNeighborhood;
import ar.fiuba.tdd.grupo04.rule.IRule;
import ar.fiuba.tdd.grupo04.rule.RuleFactory;
import ar.fiuba.tdd.grupo04.util.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameFactory {
    private static Gson gson = new Gson();

    public static IGame createGame(String gameUrl, String scenarioUrl) {
        String gameJson = FileUtils.readFile(gameUrl);
        GameMapper gameMapper = gson.fromJson(gameJson, GameMapper.class);
        String scenarioJson = FileUtils.readFile(scenarioUrl);
        ScenarioMapper scenarioMapper = gson.fromJson(scenarioJson, ScenarioMapper.class);

        // Board
        BoardMapper boardMapper = gameMapper.getBoard();
        IBoard board = new Board(boardMapper.getRows(), boardMapper.getColumns());

        // Input type --> defines Neighborhood
        String inputType = boardMapper.getInputType();
        Neighborhood neighborhood = createNeighborhood(inputType);

        // Rules
        List<IRule> winRules =
                gameMapper
                        .getWinRules()
                        .stream()
                        .map(ruleMapper -> RuleFactory.createRule(neighborhood, ruleMapper))
                        .collect(Collectors.toList());
        List<IRule> loseRules =
                gameMapper
                        .getLoseRules()
                        .stream()
                        .map(ruleMapper -> RuleFactory.createRule(neighborhood, ruleMapper))
                        .collect(Collectors.toList());

        // Game creation
        IGame game = new Game(board, winRules, loseRules);

        // Load Structure
        List<StructureMapper> structures = boardMapper.getStructure();
        game.loadStructure(getBoardStructure(board, structures));

        // Load Scenario
        //      Initial values
        List<CellMapper> cellMappers = scenarioMapper.getInitialValues();
        List<Input> inputs =
                cellMappers
                        .stream()
                        .map(GameFactory::createInput)
                        .collect(Collectors.toList());
        //      Slots
        List<SlotMapper> slotMappers = scenarioMapper.getReferences();
        List<Slot> slots =
                slotMappers
                        .stream()
                        .map(GameFactory::createSlot)
                        .collect(Collectors.toList());
        game.loadScenario(inputs, slots);

        return game;
    }

    private static List<Input> getInputsFromStructure(IBoard board, StructureMapper structureMapper) {
        int value = structureMapper.getValue();
        return structureMapper
                .getCoordinates(board.getRowSize(), board.getColumnSize())
                .stream()
                .map(coordinate -> new Input(coordinate, value))
                .collect(Collectors.toList());
    }

    private static List<Input> getBoardStructure(IBoard board, List<StructureMapper> structureMappers) {
        return structureMappers.stream()
                .map(structureMapper -> getInputsFromStructure(board, structureMapper))
                .reduce(
                        new ArrayList<>(),
                        (l1, l2) -> {
                        l1.addAll(l2);
                        return l1;
                    }
                );
    }

    private static Input createInput(CellMapper cellMapper) {
        Coordinate coordinate = new Coordinate(
                cellMapper.getRow(),
                cellMapper.getColumn()
        );
        Integer value = cellMapper.getValue();
        return new Input(coordinate, value);
    }

    private static Slot createSlot(SlotMapper slotMapper) {
        return new Slot(
                slotMapper.getCoordinates(),
                slotMapper.getValues()
        );
    }

    private static Neighborhood createNeighborhood(String inputType) {
        switch (inputType) {
            case BoardMapper.INPUT_DIAGONAL:
                return new DiagonalNeighborhood();
            case BoardMapper.INPUT_NUMERIC:
            case BoardMapper.INPUT_BOOLEAN:
            default:
                return new StraightNeighborhood();
        }
    }

}
