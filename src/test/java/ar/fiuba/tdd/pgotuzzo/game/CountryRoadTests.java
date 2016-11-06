package ar.fiuba.tdd.pgotuzzo.game;

import ar.fiuba.tdd.pgotuzzo.GameBuilder;
import ar.fiuba.tdd.pgotuzzo.IGame;
import ar.fiuba.tdd.pgotuzzo.Input;
import ar.fiuba.tdd.pgotuzzo.json.InputsMapper;
import ar.fiuba.tdd.pgotuzzo.util.FileUtils;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CountryRoadTests {
    private static final String FILE_GAME = "./src/main/resources/CountryRoad/CountryRoad.json";
    private static final String FILE_SCENARIO = "./src/main/resources/CountryRoad/init-1/init.json";
    private static final String FILE_MOVES = "./src/main/resources/CountryRoad/init-1/input-1.json";

    private static Gson gson;

    private IGame game;
    private List<Input> inputs;

    @BeforeClass
    public static void initClass() {
        gson = new Gson();
    }

    // FIXME - Continue HERE
//    @Before
//    public void init() {
//        // Game creation - CountryRoad
//        game = GameBuilder.createGame(FILE_GAME, FILE_SCENARIO);
//
//        // Inputs
//        String json = FileUtils.readFile(FILE_MOVES);
//        InputsMapper inputsMapper = gson.fromJson(json, InputsMapper.class);
//        inputs = inputsMapper.getInputs();
//    }
//
//    @Test
//    public void testWinGame() {
//        for (Input input : inputs) {
//            System.out.println(game.printBoard());
//            game.play(input);
//        }
//        System.out.println(game.printBoard());
//        assertTrue(game.hasWin());
//    }

}
