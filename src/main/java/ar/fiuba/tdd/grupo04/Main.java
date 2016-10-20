package ar.fiuba.tdd.grupo04;

import ar.fiuba.tdd.grupo04.gui.GameGui;
import ar.fiuba.tdd.grupo04.json.model.JsonGame;
import ar.fiuba.tdd.grupo04.json.model.JsonInitGame;
import ar.fiuba.tdd.grupo04.json.parser.GameJsonParser;
import ar.fiuba.tdd.grupo04.util.FileUtils;
import com.google.gson.Gson;

public class Main {
    private static final String SUDOKU_PATH = "./src/main/resources/config/sudoku.json";
    private static final String SUDOKU_MODEL_PATH = "./src/main/resources/config/sudokuGame.json";
    private static final String SUDOKU_INIT_PATH = "./src/main/resources/config/sudoku1.json";

    public static void main(String[] args) {
        String json1 = FileUtils.readFile(SUDOKU_PATH);
        if (json1 == null) {
            System.out.println("CONFIGURATION FILE DOESN'T EXISTS!");
            return;
        }
        String json2 = FileUtils.readFile(SUDOKU_MODEL_PATH);
        if (json2 == null) {
            System.out.println("CONFIGURATION FILE DOESN'T EXISTS!");
            return;
        }
        String json3 = FileUtils.readFile(SUDOKU_INIT_PATH);
        if (json3 == null) {
            System.out.println("CONFIGURATION FILE DOESN'T EXISTS!");
            return;
        }

        Gson gson = new Gson();
        JsonGame jsonGame = gson.fromJson(json2, JsonGame.class);
        IGame game = null;
        try {
            game = GameJsonParser.parseLoad(jsonGame);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JsonInitGame jsonInitGame = gson.fromJson(json3, JsonInitGame.class);
        try {
            GameJsonParser.parseInit(game, jsonInitGame);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new GameGui(json1, game);
    }

}
