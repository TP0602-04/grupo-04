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
import ar.fiuba.tdd.grupo04.model.inputs.BooleanInputModification;
import ar.fiuba.tdd.grupo04.model.inputs.DiagonalInputModification;
import ar.fiuba.tdd.grupo04.model.inputs.GraphInputModification;
import ar.fiuba.tdd.grupo04.model.inputs.NumericInputModification;
import ar.fiuba.tdd.grupo04.model.util.FileUtils;
import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GamesTest {
    private static final String SUDOKU_MODEL_PATH = "./src/main/resources/sudoku/sudoku.json";
    private static final String SUDOKU_INIT_PATH = "./src/test/resources/sudoku/init-1.json";
    private static final String SUDOKU_INPUT_PATH = "./src/test/resources/sudoku/input-1.json";
    private static final String SUDOKU_OUTPUT_PATH = "./src/test/resources/sudoku/output-1.json";

    @Test
    public void testSudoku() {
        checkGameOk(SUDOKU_MODEL_PATH, SUDOKU_INIT_PATH, SUDOKU_INPUT_PATH, SUDOKU_OUTPUT_PATH);
    }

    private static final String KAKURO_MODEL_PATH = "./src/main/resources/kakuro/kakuro.json";
    private static final String KAKURO_INIT_PATH = "./src/test/resources/kakuro/init-1.json";
    private static final String KAKURO_INPUT_PATH = "./src/test/resources/kakuro/input-1.json";
    private static final String KAKURO_OUTPUT_PATH = "./src/test/resources/kakuro/output-1.json";

    @Test
    public void testKakuro() {
        checkGameOk(KAKURO_MODEL_PATH, KAKURO_INIT_PATH, KAKURO_INPUT_PATH, KAKURO_OUTPUT_PATH);
    }

    private static final String INSHINOHEYA_MODEL_PATH = "./src/main/resources/inshiNoHeya/inshiNoHeya.json";
    private static final String INSHINOHEYA_INIT_PATH = "./src/test/resources/inshiNoHeya/init-1.json";
    private static final String INSHINOHEYA_INPUT_PATH = "./src/test/resources/inshiNoHeya/input-1.json";
    private static final String INSHINOHEYA_OUTPUT_PATH = "./src/test/resources/inshiNoHeya/output-1.json";

    @Test
    public void testInshiNoHeya() {
        checkGameOk(INSHINOHEYA_MODEL_PATH, INSHINOHEYA_INIT_PATH, INSHINOHEYA_INPUT_PATH, INSHINOHEYA_OUTPUT_PATH);
    }

    private static final String SITHERLINK_MODEL_PATH = "./src/main/resources/slitherLink/slitherLink.json";
    private static final String SITHERLINK_INIT_PATH = "./src/test/resources/slitherLink/init-1.json";
    private static final String SITHERLINK_INPUT_PATH = "./src/test/resources/slitherLink/input-1.json";
    private static final String SITHERLINK_OUTPUT_PATH = "./src/test/resources/slitherLink/output-1.json";

    @Test
    public void testSlitherLink() {
        checkGameOk(SITHERLINK_MODEL_PATH, SITHERLINK_INIT_PATH, SITHERLINK_INPUT_PATH, SITHERLINK_OUTPUT_PATH);
    }

    private void checkGameOk(String modelPath, String initPath, String inputPath, String outputPath) {
        String inputs = FileUtils.readFile(inputPath);
        String model = FileUtils.readFile(modelPath);
        String initGame = FileUtils.readFile(initPath);
        String outputFile = FileUtils.readFile(outputPath);

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

            switch (jsonGame.getBoard().getInputType()) {
                case "NumericInput": {
                    game.addInputModification(new Coordinate(input.x, input.y), new NumericInputModification(input.value));
                }
                case "GraphInput": {
                    game.addInputModification(new Coordinate(input.x, input.y), new GraphInputModification());
                }
                case "DiagonalInput": {
                    final Coordinate coordinate = new Coordinate(input.x, input.y);
                    switch (input.value) {
                        case 0: game.addInputModification(coordinate, new DiagonalInputModification(false, false));
                        case 1: game.addInputModification(coordinate, new DiagonalInputModification(false, true));
                        case 2: game.addInputModification(coordinate, new DiagonalInputModification(true, false));
                        case 3: game.addInputModification(coordinate, new DiagonalInputModification(true, true));
                    }
                }
                case "BooleanInput": {
                    game.addInputModification(new Coordinate(input.x, input.y), new BooleanInputModification());
                }
            }
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
