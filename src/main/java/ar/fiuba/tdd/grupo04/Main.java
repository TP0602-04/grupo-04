package ar.fiuba.tdd.grupo04;

import ar.fiuba.tdd.grupo04.gui.GameGui;
import ar.fiuba.tdd.grupo04.util.FileUtils;

public class Main {
    private static final String SUDOKU_PATH = "./src/main/resources/config/sudoku.json";
//    private static final String KAKURO_PATH = "./src/main/resources/config/kakuro.json";

    public static void main(String[] args) {
        String json = FileUtils.readFile(SUDOKU_PATH);
        if (json == null) {
            System.out.println("CONFIGURATION FILE DOESN'T EXISTS!");
            return;
        }
        new GameGui(json);
    }

}
