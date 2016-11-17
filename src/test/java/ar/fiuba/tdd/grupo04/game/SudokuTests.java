package ar.fiuba.tdd.grupo04.game;

public class SudokuTests extends GameTests {
    private static final String FILE_GAME = "./src/main/resources/Sudoku/Sudoku.json";
    private static final String FILE_SCENARIO = "./src/main/resources/Sudoku/init-1/init.json";
    private static final String FILE_MOVES = "./src/main/resources/Sudoku/init-1/input-1.json";

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
        return FILE_MOVES;
    }

    @Override
    String getFileMovesToLose() {
        return null;
    }
}
