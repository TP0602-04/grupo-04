package ar.fiuba.tdd.grupo04;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.json.model.JsonGame;
import ar.fiuba.tdd.grupo04.json.model.JsonInitGame;
import ar.fiuba.tdd.grupo04.json.model.JsonMove;
import ar.fiuba.tdd.grupo04.json.model.JsonMoves;
import ar.fiuba.tdd.grupo04.json.parser.GameJsonParser;
import ar.fiuba.tdd.grupo04.util.FileUtils;
import com.google.gson.Gson;

import java.util.List;

public class Main {
    //    private static final String SUDOKU_PATH = "./src/main/resources/config/sudoku.json";
    private static final String MODEL_PATH = "./src/main/resources/config/inshinoheya.json";
    private static final String INIT_PATH = "./src/main/resources/test/InshiNoHeya-Init-1.json";
    private static final String INPUT_PATH = "./src/main/resources/test/InshiNoHeya-Input-1.json";

    public static void main(String[] args) {
        String json1 = FileUtils.readFile(INPUT_PATH);
        String json2 = FileUtils.readFile(MODEL_PATH);
        String json3 = FileUtils.readFile(INIT_PATH);

        if (json1 == null || json2 == null || json3 == null) {
            System.out.println("CONFIGURATION FILE DOESN'T EXISTS!");
            return;
        }
        Gson gson = new Gson();
        JsonGame jsonGame = gson.fromJson(json2, JsonGame.class);
        IGame game = null;
        try {
            JsonInitGame jsonInitGame = gson.fromJson(json3, JsonInitGame.class);
            game = GameJsonParser.parseLoad(jsonGame, jsonInitGame);
            System.out.println(" PARA MANU ");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("+++++++++++++++START GAME++++++++++++++++");
        JsonMoves inputs = gson.fromJson(json1, JsonMoves.class);
        int i = 0;
        for (JsonMove input : inputs.inputs) {
            Coordinate coordinate = new Coordinate(input.x, input.y);
            System.out.println("JUGADA NUMERO: " + i++);
            game.fillCell(coordinate, input.value);
            if (game.checkLoseRules()) {
                System.out.println("PERDISTE");
            } else {
                System.out.println("NO PERDISTE");
            }
            if (game.checkWinRules()) {
                System.out.println("GANASTE");
            } else {
                System.out.println("HMMMMMMM elegi estoy seguro de que perderas....");
            }
        }
        System.out.println("+++++++++++++++END GAME++++++++++++++++");

//        new GameGui(json1, game);
    }

}
