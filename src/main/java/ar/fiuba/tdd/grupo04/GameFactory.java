package ar.fiuba.tdd.grupo04;

import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.board.Slot;
import ar.fiuba.tdd.grupo04.json.game.*;
import ar.fiuba.tdd.grupo04.json.scenario.CellMapper;
import ar.fiuba.tdd.grupo04.json.scenario.ScenarioMapper;
import ar.fiuba.tdd.grupo04.json.scenario.SlotMapper;
import ar.fiuba.tdd.grupo04.neighborhood.DiagonalNeighborhood;
import ar.fiuba.tdd.grupo04.neighborhood.Neighborhood;
import ar.fiuba.tdd.grupo04.neighborhood.StraightNeighborhood;
import ar.fiuba.tdd.grupo04.rule.IRule;
import ar.fiuba.tdd.grupo04.rule.Rule;
import ar.fiuba.tdd.grupo04.rule.collector.*;
import ar.fiuba.tdd.grupo04.rule.condition.*;
import ar.fiuba.tdd.grupo04.util.FileUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ar.fiuba.tdd.grupo04.json.game.CollectorMapper.*;
import static ar.fiuba.tdd.grupo04.json.game.ConditionMapper.*;

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
                        .map(ruleMapper -> createRule(ruleMapper, neighborhood))
                        .collect(Collectors.toList());
        List<IRule> loseRules =
                gameMapper
                        .getLoseRules()
                        .stream()
                        .map(ruleMapper -> createRule(ruleMapper, neighborhood))
                        .collect(Collectors.toList());

        // Game creation
        IGame game = new Game(board, winRules, loseRules);

        // Load Structure
        List<StructureMapper> structures = boardMapper.getStructure();
        List<Input> structureInputs = getBoardStructure(board, structures);
        game.loadStructure(structureInputs);

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

    private static IRule createRule(RuleMapper ruleMapper, Neighborhood neighborhood) {
        CollectorMapper collectorMapper = ruleMapper.getCollector();
        ICollector collector = createCollector(collectorMapper);
        List<ConditionMapper> conditionMappers = ruleMapper.getConditions();
        List<ICondition> conditions = new ArrayList<>();
        for (ConditionMapper conditionMapper : conditionMappers) {
            ICondition condition = createCondition(conditionMapper, neighborhood);
            conditions.add(condition);
        }
        return new Rule(collector, conditions);
    }

    private static ICollector createCollector(CollectorMapper collectorMapper) {
        final String type = collectorMapper.getType();
        int filterValue;
        List<Integer> filterValues;
        switch (type) {
            case ALL:
                return new AllCollector();
            case ROWS:
                return new RowCollector();
            case COLUMNS:
                return new ColumnCollector();
            case BLOCKS:
                int blockSize = collectorMapper.getParams().get(0);
                return new BlockCollector(blockSize);
            case VALUED:
                filterValues = collectorMapper.getParams();
                return new ValuedCollector(filterValues);
            case CUSTOM:
                return new CustomCollector();
            case CUSTOM_VALUED:
                filterValues = collectorMapper.getParams();
                return new CustomValuedCollector(filterValues);
            default:
                throw new RuntimeException("Parsing error! Check collectors' name. " + type + " NOT VALID!");
        }
    }

    private static ICondition createCondition(ConditionMapper conditionMapper, Neighborhood neighborhood) {
        final String type = conditionMapper.getType();
        switch (type) {
            case UNIQUE:
                return new UniqueCondition();
            case GREATER_THAN:
                int minValue = conditionMapper.getParams().get(0);
                return new GreaterThanCondition(minValue);
            case LESSER_THAN:
                int maxValue = conditionMapper.getParams().get(0);
                return new LesserThanCondition(maxValue);
            case FILLED:
                return new FilledCondition();
            case EQUALS_SUM:
                return new EqualsSumCondition();
            case EQUALS_MULTIPLY:
                return new EqualsMultiplyCondition();
            case SINGLE_LOOP:
                return new SingleLoopCondition(neighborhood);
            case NO_LOOP:
                return new NoLoopCondition(neighborhood);
            case COUNT_WITHIN_RANGE:
                return new CountWithinRange();
            default:
                throw new RuntimeException("Parsing error! Check conditions' name. " + type + " NOT VALID!");
        }
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
