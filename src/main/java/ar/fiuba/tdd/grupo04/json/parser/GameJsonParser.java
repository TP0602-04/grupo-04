package ar.fiuba.tdd.grupo04.json.parser;

import ar.fiuba.tdd.grupo04.json.model.*;
import ar.fiuba.tdd.grupo04.model.Game;
import ar.fiuba.tdd.grupo04.model.IGame;
import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.board.IBoard;
import ar.fiuba.tdd.grupo04.model.board.reference.ReferencedBlockGroup;
import ar.fiuba.tdd.grupo04.model.inputs.BooleanInputModification;
import ar.fiuba.tdd.grupo04.model.inputs.DiagonalInputModification;
import ar.fiuba.tdd.grupo04.model.inputs.GraphInputModification;
import ar.fiuba.tdd.grupo04.model.inputs.NumericInputModification;
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

@SuppressWarnings("CPD-START")
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
                List<Coordinate> coordinates = reference.getCoordinates();
                Integer value = reference.getValue();
                ReferencedBlockGroup blockGroup = new ReferencedBlockGroup(coordinates, value);
                customCollector.addReferencedGroup(blockGroup);
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
                List<Pair<Coordinate, Integer>> initialValues = getInitCells(jsonInitGame);
                for (Pair<Coordinate, Integer> cell : initialValues) {
                    game.addInputModification(cell.getKey(), new NumericInputModification(cell.getValue()));
                }
                break;
            }
            case "GraphInput": {
                List<Pair<Coordinate, Integer>> initialValues = getInitCells(jsonInitGame);
                for (Pair<Coordinate, Integer> cell : initialValues) {
                    game.addInputModification(cell.getKey(), new GraphInputModification());
                }
                break;
            }
            case "DiagonalInput": {
                List<Pair<Coordinate, Integer>> initialValues = getInitCells(jsonInitGame);
                for (Pair<Coordinate, Integer> cell : initialValues) {
                    switch (cell.getValue()) {
                        case 0:
                            game.addInputModification(cell.getKey(), new DiagonalInputModification(false, false));
                            break;
                        case 1:
                            game.addInputModification(cell.getKey(), new DiagonalInputModification(false, true));
                            break;
                        case 2:
                            game.addInputModification(cell.getKey(), new DiagonalInputModification(true, false));
                            break;
                        default:
                            game.addInputModification(cell.getKey(), new DiagonalInputModification(true, true));
                            break;
                    }
                }
                break;
            }
            case "BooleanInput": {
                List<Pair<Coordinate, Integer>> initialValues = getInitCells(jsonInitGame);
                for (Pair<Coordinate, Integer> cell : initialValues) {
                    game.addInputModification(cell.getKey(), new BooleanInputModification());
                }
                break;
            }
            default: {
            }
        }
        return game;
    }

    private static List<Pair<ICollector, List<ICondition>>> getRuleComponents(List<JsonRules> jsonRules, IBoard board) throws Exception {
        List<Pair<ICollector, List<ICondition>>> list = new ArrayList<>();
        for (JsonRules rule : jsonRules) {
            ICollector collector = CollectorJsonParser.parse(rule.getCollector(), board);
            List<ICondition> conditions = ConditionJsonParser.parse(rule.getCondition(), board);
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
