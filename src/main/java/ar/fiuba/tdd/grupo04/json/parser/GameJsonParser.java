package ar.fiuba.tdd.grupo04.json.parser;

import ar.fiuba.tdd.grupo04.Game;
import ar.fiuba.tdd.grupo04.IGame;
import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.reference.builder.ReferencedBlockGroupBuilder;
import ar.fiuba.tdd.grupo04.json.model.*;
import ar.fiuba.tdd.grupo04.rule.IRule;
import ar.fiuba.tdd.grupo04.rule.Rule;
import ar.fiuba.tdd.grupo04.rule.collector.CustomGroupCollector;
import ar.fiuba.tdd.grupo04.rule.collector.ICollector;
import ar.fiuba.tdd.grupo04.rule.condition.ICondition;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameJsonParser {
    public static IGame parseLoad(JsonGame jsonGame, JsonInitGame jsonInitGame) throws Exception {
        IGame game = new Game();
        Board board = BoardJsonParser.parse(jsonGame.getBoard());
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
        List<Pair<Coordinate, Integer>> initialValues = getInitCells(jsonInitGame);
        for (Pair<Coordinate, Integer> cell : initialValues) {
            //TODO
//            game.fillCell(cell.getKey(), cell.getValue());
        }

        return game;
    }

    private static List<Pair<ICollector, List<ICondition>>> getRuleComponents(List<JsonRules> jsonRules, Board board) throws Exception {
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
