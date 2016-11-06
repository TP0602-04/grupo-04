package ar.fiuba.tdd.pgotuzzo;

import ar.fiuba.tdd.pgotuzzo.json.game.BoardMapper;
import ar.fiuba.tdd.pgotuzzo.json.game.GameMapper;
import ar.fiuba.tdd.pgotuzzo.rule.IRule;
import ar.fiuba.tdd.pgotuzzo.util.FileUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class GameBuilder {
    private static Gson gson = new Gson();

    public static IGame createGame(String gameUrl) {
        String gameJson = FileUtils.readFile(gameUrl);
        GameMapper gameMapper = gson.fromJson(gameJson, GameMapper.class);

        // Board
        BoardMapper boardMapper = gameMapper.getBoard();
        Board board = new Board(boardMapper.getRows(), boardMapper.getColumns());

        // Rules
        List<IRule> winRules = new ArrayList<>();
//        gameMapper.getLoseRules().stream().map(
//                ruleMapper ->
//        )

        // FIXME - Continue
        return new Game(board, new ArrayList<>(), new ArrayList<>());
    }

}
