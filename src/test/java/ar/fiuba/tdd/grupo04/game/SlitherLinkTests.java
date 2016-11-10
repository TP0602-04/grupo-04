package ar.fiuba.tdd.grupo04.game;

import ar.fiuba.tdd.grupo04.GameBuilder;
import ar.fiuba.tdd.grupo04.IGame;
import ar.fiuba.tdd.grupo04.Input;
import ar.fiuba.tdd.grupo04.json.InputsMapper;
import ar.fiuba.tdd.grupo04.util.FileUtils;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SlitherLinkTests {
    private static final String FILE_GAME = "./src/main/resources/SlitherLink/SlitherLink.json";
    private static final String FILE_SCENARIO = "./src/main/resources/SlitherLink/init-1/init.json";
    private static final String FILE_MOVES = "./src/main/resources/SlitherLink/init-1/input-1.json";

    private static Gson gson;

    private IGame game;
    private List<Input> inputs;

    @BeforeClass
    public static void initClass() {
        gson = new Gson();
    }

    @Before
    public void init() {
        // Game creation - SlitherLink
        game = GameBuilder.createGame(FILE_GAME, FILE_SCENARIO);

        // Inputs
        String json = FileUtils.readFile(FILE_MOVES);
        InputsMapper inputsMapper = gson.fromJson(json, InputsMapper.class);
        inputs = inputsMapper.getInputs();
    }

    @Test
    public void testWinGame() {
        for (Input input : inputs) {
            System.out.println(game.printBoard());
            game.play(input);
        }
        System.out.println(game.printBoard());
        assertTrue(game.hasWin());
    }

}
