package ar.fiuba.tdd.grupo04;

import ar.fiuba.tdd.grupo04.gui.GameGui;
import ar.fiuba.tdd.grupo04.util.FileUtils;

import java.util.Random;

public class Main {
    private static final String SUDOKU_PATH = "./src/main/resources/config/sudoku.json";
    private static final String KAKURO_PATH = "./src/main/resources/config/kakuro.json";

    public static void main(String[] args) {
        String json = FileUtils.readFile(SUDOKU_PATH);
        if (json == null) {
            System.out.println("CONFIGURATION FILE DOESN'T EXISTS!");
            return;
        }
        GameGui.create(json);
        gameLoop();
    }

    // FIXME - Remove
    public static void gameLoop() {
        Thread t = new Thread() {

            private synchronized void play() throws Exception {
                wait(5000);
                int number = new Random().nextInt(9);
                GameGui.onInput(String.valueOf(number));
            }

            @Override
            public void run() {
                try {
                    play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gameLoop();
            }
        };
        t.start();
    }

}
