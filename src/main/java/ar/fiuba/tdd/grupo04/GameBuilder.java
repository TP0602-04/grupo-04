package ar.fiuba.tdd.grupo04;

import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.board.Slot;
import ar.fiuba.tdd.grupo04.json.game.*;
import ar.fiuba.tdd.grupo04.json.scenario.CellMapper;
import ar.fiuba.tdd.grupo04.json.scenario.ScenarioMapper;
import ar.fiuba.tdd.grupo04.json.scenario.SlotMapper;
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

public class GameBuilder {
    private static Gson gson = new Gson();

    public static IGame createGame(String gameUrl, String scenarioUrl) {
        String gameJson = FileUtils.readFile(gameUrl);
        GameMapper gameMapper = gson.fromJson(gameJson, GameMapper.class);
        String scenarioJson = FileUtils.readFile(scenarioUrl);
        ScenarioMapper scenarioMapper = gson.fromJson(scenarioJson, ScenarioMapper.class);

        // Board
        BoardMapper boardMapper = gameMapper.getBoard();
        IBoard board = new Board(boardMapper.getRows(), boardMapper.getColumns());
        //      Structure - Even/Odd cells
        List<StructureMapper> structures = boardMapper.getStructure();
        structures.forEach(structureMapper -> {
            boolean isColumnEven = structureMapper.getColumnRange().equals(StructureMapper.EVEN);
            boolean isRowEven = structureMapper.getRowRange().equals(StructureMapper.EVEN);
            List<Coordinate> coordinates = filterBoard(board, isRowEven, isColumnEven);
            coordinates.forEach(coordinate -> {
                Input input = new Input(coordinate, structureMapper.getValue());
                board.fill(input);
                board.lockCell(coordinate);
            });
        });

        // Rules
        List<IRule> winRules =
                gameMapper
                        .getWinRules()
                        .stream()
                        .map(GameBuilder::createRule)
                        .collect(Collectors.toList());
        List<IRule> loseRules =
                gameMapper
                        .getLoseRules()
                        .stream()
                        .map(GameBuilder::createRule)
                        .collect(Collectors.toList());

        // Game creation
        IGame game = new Game(board, winRules, loseRules);

        // Load Scenario
        //      Initial values
        List<CellMapper> cellMappers = scenarioMapper.getInitialValues();
        List<Input> inputs =
                cellMappers
                        .stream()
                        .map(GameBuilder::createInput)
                        .collect(Collectors.toList());
        //      Slots
        List<SlotMapper> slotMappers = scenarioMapper.getReferences();
        List<Slot> slots =
                slotMappers
                        .stream()
                        .map(GameBuilder::createSlot)
                        .collect(Collectors.toList());
        game.loadScenario(inputs, slots);

        return game;
    }

    private static List<Coordinate> filterBoard(IBoard board, boolean isRowEven, boolean isColumnEven) {
        return board.getCells()
                .stream()
                .map(Cell::getCoordinate)
                .filter(coordinate ->
                        (isRowEven && coordinate.row() % 2 == 0 || !isRowEven && coordinate.row() % 2 != 0) &&
                                (isColumnEven && coordinate.column() % 2 == 0 || !isColumnEven && coordinate.column() % 2 != 0)
                )
                .collect(Collectors.toList());
    }

    private static IRule createRule(RuleMapper ruleMapper) {
        CollectorMapper collectorMapper = ruleMapper.getCollector();
        ICollector collector = createCollector(collectorMapper);
        List<ConditionMapper> conditionMappers = ruleMapper.getConditions();
        List<ICondition> conditions = new ArrayList<>();
        for (ConditionMapper conditionMapper : conditionMappers) {
            ICondition condition = createCondition(conditionMapper);
            conditions.add(condition);
        }
        return new Rule(collector, conditions);
    }

    private static ICollector createCollector(CollectorMapper collectorMapper) {
        final String type = collectorMapper.getType();
        int filterValue;
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
                filterValue = collectorMapper.getParams().get(0);
                return new ValuedCollector(filterValue);
            case CUSTOM:
                return new CustomCollector();
            case CUSTOM_VALUED:
                filterValue = collectorMapper.getParams().get(0);
                return new CustomValuedCollector(filterValue);
            default:
                throw new RuntimeException("Parsing error! Check collectors' name. " + type + " NOT VALID!");
        }
    }

    private static ICondition createCondition(ConditionMapper conditionMapper) {
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
            case LOOP:
                return new LoopCondition();
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

}
