package ar.fiuba.tdd.grupo04.games;

import ar.fiuba.tdd.pgotuzzo.util.FileUtils;
import com.google.gson.Gson;

import ar.fiuba.tdd.grupo04.IGame;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.json.model.JsonGame;
import ar.fiuba.tdd.grupo04.json.model.JsonInitGame;
import ar.fiuba.tdd.grupo04.json.model.JsonMove;
import ar.fiuba.tdd.grupo04.json.model.JsonMoves;
import ar.fiuba.tdd.grupo04.json.parser.GameJsonParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SudokuTests {
    private IGame game;
    private Gson gson;

    @Before
    public void init() {
        String gameJson = FileUtils.readFile("./src/main/resources/Sudoku/Sudoku.json");
        String initJson = FileUtils.readFile("./src/main/resources/Sudoku/init-1/init.json");
        if (gameJson == null || initJson == null) {
            fail("invalid resource files");
        }
        gson = new Gson();
        try {
            game = GameJsonParser.parseLoad(gson.fromJson(gameJson, JsonGame.class), gson.fromJson(initJson, JsonInitGame.class));
        } catch (Exception e) {
            e.printStackTrace();
            fail("error reading json structure");
        }
    }

    @Test
    public void testWinGame() {
        String inputJson = FileUtils.readFile("./src/main/resources/Sudoku/init-1/input-1.json");
        if (inputJson == null) {
            fail("invalid resource file");
        }
        JsonMoves moves = gson.fromJson(inputJson, JsonMoves.class);
        for (JsonMove move : moves.inputs) {
            game.fillCell(move.getCoordinate(), move.getValue());
            assertFalse(game.checkLoseRules());
        }
        assertTrue(game.checkWinRules());
    }

}