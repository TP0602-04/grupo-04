package ar.fiuba.tdd.grupo04.game;

public class GokigenNanameTests extends GameTests {
    private static final String FILE_GAME = "./src/main/resources/GokigenNaname/GokigenNaname.json";
    private static final String FILE_SCENARIO = "./src/main/resources/GokigenNaname/init-1/init.json";
    private static final String FILE_MOVES_WIN = "./src/main/resources/GokigenNaname/init-1/input-1.json";
    private static final String FILE_MOVES_LOSE = "./src/main/resources/GokigenNaname/init-1/input-2.json";

    @Override
    String getFileGame() {
        return FILE_GAME;
    }

    @Override
    String getFileScenario() {
        return FILE_SCENARIO;
    }

    @Override
    String getFileMovesToWin() {
        return FILE_MOVES_WIN;
    }

    @Override
    String getFileMovesToLose() {
        return FILE_MOVES_LOSE;
    }
}
