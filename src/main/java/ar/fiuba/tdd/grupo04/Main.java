package ar.fiuba.tdd.grupo04;

import com.google.gson.Gson;

import ar.fiuba.tdd.grupo04.gui.GameGui;
import ar.fiuba.tdd.grupo04.json.model.JsonGame;
import ar.fiuba.tdd.grupo04.json.model.JsonInitGame;
import ar.fiuba.tdd.grupo04.json.parser.GameJsonParser;
import ar.fiuba.tdd.grupo04.util.FileUtils;


public class Main {
    private static final String SUDOKU_PATH = "./src/main/resources/config/sudoku.json";
    private static final String SUDOKU_MODEL_PATH = "./src/main/resources/config/sudokuGame.json";
    private static final String SUDOKU_INIT_PATH = "./src/main/resources/config/sudoku1.json";

    public static void main(String[] args) {
        String json1 = FileUtils.readFile(SUDOKU_PATH);
        String json3 = FileUtils.readFile(SUDOKU_INIT_PATH);
        String json2 = FileUtils.readFile(SUDOKU_MODEL_PATH);

        if (json1 == null || json2 == null || json3 == null) {
            System.out.println("CONFIGURATION FILE DOESN'T EXISTS!");
            return;
        }
        Gson gson = new Gson();
        JsonGame jsonGame = gson.fromJson(json2, JsonGame.class);
        IGame game = null;
        try {
            game = GameJsonParser.parseLoad(jsonGame);
            JsonInitGame jsonInitGame = gson.fromJson(json3, JsonInitGame.class);
            GameJsonParser.parseInit(game, jsonInitGame);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new GameGui(json1, game);
    }

}
