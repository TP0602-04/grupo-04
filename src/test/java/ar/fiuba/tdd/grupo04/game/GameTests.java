package ar.fiuba.tdd.grupo04.game;

import ar.fiuba.tdd.grupo04.GameFactory;
import ar.fiuba.tdd.grupo04.IGame;
import ar.fiuba.tdd.grupo04.Input;
import ar.fiuba.tdd.grupo04.json.InputsMapper;
import ar.fiuba.tdd.grupo04.util.FileUtils;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class GameTests {
    private static Gson gson;

    private IGame game;
    private List<Input> inputsToWin;
    private List<Input> inputsToLose;

    abstract String getFileGame();

    abstract String getFileScenario();

    abstract String getFileMovesToWin();

    abstract String getFileMovesToLose();

    @BeforeClass
    public static void initClass() {
        gson = new Gson();
    }

    @Before
    public void init() {
        // Game creation
        game = GameFactory.createGame(getFileGame(), getFileScenario());

        String json;
        InputsMapper inputsMapper;

        // Inputs to Win
        String winGame = getFileMovesToWin();
        inputsToWin = new ArrayList<>();
        if (winGame != null) {
            json = FileUtils.readFile(getFileMovesToWin());
            inputsMapper = gson.fromJson(json, InputsMapper.class);
            inputsToWin = inputsMapper.getInputs();
        }

        // Inputs to Lose
        String loseGame = getFileMovesToLose();
        inputsToLose = new ArrayList<>();
        if (loseGame != null) {
            json = FileUtils.readFile(loseGame);
            inputsMapper = gson.fromJson(json, InputsMapper.class);
            inputsToLose = inputsMapper.getInputs();
        }
    }

    @Test
    public void testWinGame() {
        playGame(game, inputsToWin);
        assertTrue(game.hasWin());
    }

    @Test
    public void testLoseGame() {
        if (!inputsToLose.isEmpty()) {
            playGame(game, inputsToLose);
            assertFalse(game.hasWin());
        }
    }

    @Test
    public void testUndo() {
        playGame(game, inputsToWin);
        assertTrue(game.hasWin());
        System.out.println("======================== UNDO ==============================");
        game.undo();
        System.out.println(game.printBoard());
        assertFalse(game.hasWin());
        doMove(game, inputsToWin.get(inputsToWin.size() - 1));
        assertTrue(game.hasWin());
        System.out.println("======================== END ==============================");
    }

    private void playGame(IGame game, List<Input> inputs) {
        System.out.println("======================== INIT ==============================");
        System.out.println(game.printBoard());
        for (Input input : inputs) {
            doMove(game, input);
        }
        System.out.println("======================== END ==============================");
    }

    private void doMove(IGame game, Input input) {
        System.out.println("======================== MOVE ==============================");
        game.play(input);
        System.out.println(game.printBoard());
        game.hasWin();
        System.out.println("============================================================");
    }

}
