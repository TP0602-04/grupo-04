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

    private static final String COUTRYROAD_MODEL_PATH = "./src/main/resources/countryroad/countryroad.json";
    private static final String COUTRYROAD_INIT_PATH = "./src/test/resources/countryroad/init-1.json";
    private static final String COUTRYROAD_INPUT_PATH = "./src/test/resources/countryroad/input-1.json";
    private static final String COUTRYROAD_OUTPUT_PATH = "./src/test/resources/countryroad/output-1.json";

    @Test
    public void testCountryRoad() {
        checkGameOk(COUTRYROAD_MODEL_PATH, COUTRYROAD_INIT_PATH, COUTRYROAD_INPUT_PATH, COUTRYROAD_OUTPUT_PATH);
    }

    private static final String NORINORI_MODEL_PATH = "./src/main/resources/norinori/norinori.json";
    private static final String NORINORI_INIT_PATH = "./src/test/resources/norinori/init-1.json";
    private static final String NORINORI_INPUT_PATH = "./src/test/resources/norinori/input-1.json";
    private static final String NORINORI_OUTPUT_PATH = "./src/test/resources/norinori/output-1.json";

    @Test
    public void testNorinori() {
        // http://www.nikoli.com/en/puzzles/norinori/rule.html
        checkGameOk(NORINORI_MODEL_PATH, NORINORI_INIT_PATH, NORINORI_INPUT_PATH, NORINORI_OUTPUT_PATH);
    }

    private static final String NORINORI2_MODEL_PATH = "./src/main/resources/norinori/norinori-10-10.json";
    private static final String NORINORI2_INIT_PATH = "./src/test/resources/norinori/init-2.json";
    private static final String NORINORI2_INPUT_PATH = "./src/test/resources/norinori/input-2.json";
    private static final String NORINORI2_OUTPUT_PATH = "./src/test/resources/norinori/output-2.json";

    @Test
    public void testNorinori2() {
        // http://www.nikoli.com/en/puzzles/norinori/rule.html
        checkGameOk(NORINORI2_MODEL_PATH, NORINORI2_INIT_PATH, NORINORI2_INPUT_PATH, NORINORI2_OUTPUT_PATH);
    }

    private static final String GOKIGENNANAME_MODEL_PATH = "./src/main/resources/gokigenNaname/gokigenNaname.json";
    private static final String GOKIGENNANAME_INIT_PATH = "./src/test/resources/gokigenNaname/init-1.json";
    private static final String GOKIGENNANAME_INPUT_PATH = "./src/test/resources/gokigenNaname/input-1.json";
    private static final String GOKIGENNANAME_OUTPUT_PATH = "./src/test/resources/gokigenNaname/output-1.json";

    @Test
    public void testGokigenNaname() {
        checkGameOk(GOKIGENNANAME_MODEL_PATH, GOKIGENNANAME_INIT_PATH, GOKIGENNANAME_INPUT_PATH, GOKIGENNANAME_OUTPUT_PATH);
    }

    private static final String RIPPLEEFFECT_MODEL_PATH = "./src/main/resources/rippleEffect/rippleEffect.json";
    private static final String RIPPLEEFFECT_INIT_PATH = "./src/test/resources/rippleEffect/init-1.json";
    private static final String RIPPLEEFFECT_INPUT_PATH = "./src/test/resources/rippleEffect/input-1.json";
    private static final String RIPPLEEFFECT_OUTPUT_PATH = "./src/test/resources/rippleEffect/output-1.json";

    @Test
    public void testRippleEffect() {
        // http://www.nikoli.co.jp/en/puzzles/ripple_effect.html
        checkGameOk(RIPPLEEFFECT_MODEL_PATH, RIPPLEEFFECT_INIT_PATH, RIPPLEEFFECT_INPUT_PATH, RIPPLEEFFECT_OUTPUT_PATH);
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


        int asd =  moves.inputs.size()-1;
        int asd2 =  0;

        for (JsonMove input : moves.inputs) {
            asd2 = asd2+1;

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
                        case 0: game.addInputModification(coordinate, new DiagonalInputModification(false, false));break;
                        case 1: game.addInputModification(coordinate, new DiagonalInputModification(false, true));break;
                        case 2: game.addInputModification(coordinate, new DiagonalInputModification(true, false));break;
                        case 3: game.addInputModification(coordinate, new DiagonalInputModification(true, true));break;
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
