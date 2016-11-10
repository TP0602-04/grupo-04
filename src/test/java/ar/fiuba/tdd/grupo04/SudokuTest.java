package ar.fiuba.tdd.grupo04;

import ar.fiuba.tdd.grupo04.json.model.JsonGame;
import ar.fiuba.tdd.grupo04.json.model.JsonInitGame;
import ar.fiuba.tdd.grupo04.json.model.JsonMove;
import ar.fiuba.tdd.grupo04.json.model.JsonMoves;
import ar.fiuba.tdd.grupo04.json.model.JsonOutput;
import ar.fiuba.tdd.grupo04.json.model.JsonOutputStatus;
import ar.fiuba.tdd.grupo04.json.parser.GameJsonParser;
import ar.fiuba.tdd.grupo04.model.IGame;
import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.inputs.NumericInput;
import ar.fiuba.tdd.grupo04.model.inputs.NumericInputModification;
import ar.fiuba.tdd.grupo04.model.util.FileUtils;
import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SudokuTest {
    private static final String MODEL_PATH = "./src/main/resources/sudoku/sudoku.json";
    private static final String INIT_PATH = "./src/test/resources/sudoku/init-1.json";
    private static final String INPUT_PATH = "./src/test/resources/sudoku/input-1.json";
    private static final String OUTPUT_PATH = "./src/test/resources/sudoku/output-1.json";

	@Test
	public void testCheckGameOk() {
        String inputs = FileUtils.readFile(INPUT_PATH);
        String model = FileUtils.readFile(MODEL_PATH);
        String initGame = FileUtils.readFile(INIT_PATH);
        String outputFile = FileUtils.readFile(OUTPUT_PATH);

        if (inputs == null || model == null || initGame == null) {
            throw new NullPointerException();
        }

        Gson gson = new Gson();
        JsonGame jsonGame = gson.fromJson(model, JsonGame.class);
        IGame game = null;
        try {
            JsonInitGame jsonInitGame = gson.fromJson(initGame, JsonInitGame.class);
            game = GameJsonParser.parseLoad(jsonGame, jsonInitGame);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (game == null) {
            throw new NullPointerException();
        }

        String output = "";
        String expectedOutput = "";

        JsonOutput jsonOutput = gson.fromJson(outputFile, JsonOutput.class);
        for (JsonOutputStatus status : jsonOutput.getOutputs()) {
            expectedOutput = expectedOutput.concat(status.getStatus());
        }

        JsonMoves moves = gson.fromJson(inputs, JsonMoves.class);
        for (JsonMove input : moves.inputs) {
            game.addInputModification(new Coordinate(input.x, input.y), new NumericInputModification(input.value));
            if (game.checkLoseRules()) {
                output = output.concat("lose");
            } else if (game.checkWinRules()) {
                output = output.concat("win");
            } else {
                output = output.concat("ok");
            }
        }
        assertEquals(expectedOutput, output);
    }
}
