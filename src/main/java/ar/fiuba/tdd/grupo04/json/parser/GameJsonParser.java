package ar.fiuba.tdd.grupo04.json.parser;

import ar.fiuba.tdd.grupo04.model.Game;
import ar.fiuba.tdd.grupo04.model.IGame;
import ar.fiuba.tdd.grupo04.model.board.Board;
import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.board.IBoard;
import ar.fiuba.tdd.grupo04.model.board.reference.builder.ReferencedBlockGroupBuilder;
import ar.fiuba.tdd.grupo04.json.model.JsonCellGroup;
import ar.fiuba.tdd.grupo04.json.model.JsonGame;
import ar.fiuba.tdd.grupo04.json.model.JsonInitGame;
import ar.fiuba.tdd.grupo04.json.model.JsonInitValue;
import ar.fiuba.tdd.grupo04.json.model.JsonReference;
import ar.fiuba.tdd.grupo04.json.model.JsonRules;
import ar.fiuba.tdd.grupo04.model.inputs.DiagonalInput;
import ar.fiuba.tdd.grupo04.model.inputs.GraphInput;
import ar.fiuba.tdd.grupo04.model.inputs.IInput;
import ar.fiuba.tdd.grupo04.model.inputs.NumericInput;
import ar.fiuba.tdd.grupo04.model.inputs.factories.DiagonalInputFactory;
import ar.fiuba.tdd.grupo04.model.inputs.factories.GraphInputFactory;
import ar.fiuba.tdd.grupo04.model.inputs.factories.NumericInputFactory;
import ar.fiuba.tdd.grupo04.model.rule.IRule;
import ar.fiuba.tdd.grupo04.model.rule.Rule;
import ar.fiuba.tdd.grupo04.model.rule.collector.CustomGroupCollector;
import ar.fiuba.tdd.grupo04.model.rule.collector.ICollector;
import ar.fiuba.tdd.grupo04.model.rule.condition.ICondition;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameJsonParser {

    public static IGame parseLoad(JsonGame jsonGame, JsonInitGame jsonInitGame) throws Exception {
        IGame game = new Game();
        IBoard board = BoardJsonParser.parse(jsonGame.getBoard());
        if (board == null) {
            return null;
        }
        game.setBoard(board);

        // Load references
        List<JsonReference> initialReferences = jsonInitGame.getReferences();

        // Load rules
        List<Pair<ICollector, List<ICondition>>> winRuleComponents = getRuleComponents(jsonGame.getWinRules(), board);
        List<Pair<ICollector, List<ICondition>>> loseRuleComponents = getRuleComponents(jsonGame.getLoseRules(), board);

        List<ICollector> customs =
                Stream.concat(winRuleComponents.stream(), loseRuleComponents.stream())
                        .map(Pair::getKey)
                        .filter(collector -> collector instanceof CustomGroupCollector).collect(Collectors.toList());

        for (ICollector collector : customs) {
            CustomGroupCollector customCollector = (CustomGroupCollector) collector;
            for (JsonReference reference : initialReferences) {
                JsonCellGroup group = reference.getGroup();
                ReferencedBlockGroupBuilder builder = new ReferencedBlockGroupBuilder();
                builder.referencedValue(reference.getValue())
                        .rowOffset(group.getOffsetX())
                        .columnOffset(group.getOffsetY())
                        .columnLarge(group.getDeltaY())
                        .rowLarge(group.getDeltaX());
                customCollector.addReferencedGroup(builder.createReference());
            }
        }

        for (Pair<ICollector, List<ICondition>> components : winRuleComponents) {
            for (ICondition condition : components.getValue()) {
                IRule rule = new Rule<>(components.getKey(), condition);
                game.addWinRule(rule);
            }
        }

        for (Pair<ICollector, List<ICondition>> components : loseRuleComponents) {
            for (ICondition condition : components.getValue()) {
                IRule rule = new Rule<>(components.getKey(), condition);
                game.addLoseRule(rule);
            }
        }

        // Load initial values
        switch (jsonGame.getBoard().getInputType()) {
            case "NumericInput": {
                IGame<NumericInput> clGame = (IGame<NumericInput>) game;
                List<Pair<Coordinate, Integer>> initialValues = getInitCells(jsonInitGame);
                for (Pair<Coordinate, Integer> cell : initialValues) {
                    clGame.getCell(cell.getKey()).setValue(cell.getValue());
                }
                return clGame;
            }
            case "GraphInput": {
                IGame<GraphInput> clGame = (IGame<GraphInput>) game;
                List<Pair<Coordinate, Integer>> initialValues = getInitCells(jsonInitGame);
                for (Pair<Coordinate, Integer> cell : initialValues) {
                    clGame.getCell(cell.getKey()).toogleMarked();
                }
                return clGame;
            }
            case "DiagonalInput": {
                IGame<DiagonalInput> clGame = (IGame<DiagonalInput>) game;
                List<Pair<Coordinate, Integer>> initialValues = getInitCells(jsonInitGame);
                for (Pair<Coordinate, Integer> cell : initialValues) {
                    clGame.getCell(cell.getKey()).toogleMarked();
                }
                return clGame;
            }
        }
        return null;
    }

    private static List<Pair<ICollector, List<ICondition>>> getRuleComponents(List<JsonRules> jsonRules, IBoard board) throws Exception {
        List<Pair<ICollector, List<ICondition>>> list = new ArrayList<>();
        for (JsonRules rule : jsonRules) {
            ICollector collector = CollectorJsonParser.parse(rule.getCollector(), board);
            List<ICondition> conditions = ConditionJsonParser.parse(rule.getCondition());
            list.add(new Pair<>(collector, conditions));
        }
        return list;
    }

    private static List<Pair<Coordinate, Integer>> getInitCells(JsonInitGame jsonInitGame) {
        List<Pair<Coordinate, Integer>> cells = new ArrayList<>();
        List<JsonInitValue> jsonInitialValues = jsonInitGame.getInitialValues();
        for (JsonInitValue jsonInitValue : jsonInitialValues) {
            Pair<Coordinate, Integer> cell = new Pair<>(
                    new Coordinate(jsonInitValue.getRow(), jsonInitValue.getColumn()),
                    jsonInitValue.getValue()
            );
            cells.add(cell);
        }
        return cells;
    }
}
