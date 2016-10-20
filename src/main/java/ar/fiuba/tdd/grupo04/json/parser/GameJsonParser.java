package ar.fiuba.tdd.grupo04.json.parser;

import ar.fiuba.tdd.grupo04.Game;
import ar.fiuba.tdd.grupo04.IGame;
import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.json.model.JsonGame;
import ar.fiuba.tdd.grupo04.json.model.JsonInitGame;
import ar.fiuba.tdd.grupo04.json.model.JsonInitValue;
import ar.fiuba.tdd.grupo04.json.model.JsonRules;
import ar.fiuba.tdd.grupo04.rule.Rule;
import ar.fiuba.tdd.grupo04.rule.collector.ICollector;
import ar.fiuba.tdd.grupo04.rule.condition.ICondition;

import java.util.ArrayList;
import java.util.List;

public class GameJsonParser {
    public static IGame parseLoad(JsonGame jsonGame) throws Exception {
        IGame game = new Game();
        Board board = BoardJsonParser.parse(jsonGame.getBoard());
        game.setBoard(board);
        List<Rule> loseRules = parseRules(jsonGame.getLoseRules(), board);
        List<Rule> winRules = parseRules(jsonGame.getWinRules(), board);
        loseRules.forEach(game::addLoseRule);
        winRules.forEach(game::addWinRule);
        return game;
    }

    private static List<Rule> parseRules(List<JsonRules> jsonRules, Board board) throws Exception{
        List<Rule> loseRules = new ArrayList<>();
        for (JsonRules rule : jsonRules) {
            ICollector collector = CollectorJsonParser.parse(rule.getCollector(), board);
            ICondition condition = ConditionJsonParser.parse(rule.getCondition());
            loseRules.add(new Rule<>(collector, condition));
        }
        return loseRules;
    }

    public static void parseInit(IGame game, JsonInitGame jsonInitGame) {
        List<JsonInitValue> jsonInitialValues = jsonInitGame.getInitialValues();
        for(JsonInitValue jsonInitValue : jsonInitialValues) {
            game.fillCell(new Coordinate(jsonInitValue.getRow(), jsonInitValue.getColumn()), jsonInitValue.getValue());
        }
    }
}
