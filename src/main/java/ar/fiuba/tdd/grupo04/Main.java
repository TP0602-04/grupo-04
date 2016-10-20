package ar.fiuba.tdd.grupo04;

import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.gui.GameGui;
import ar.fiuba.tdd.grupo04.rule.Rule;
import ar.fiuba.tdd.grupo04.rule.collector.AllCollector;
import ar.fiuba.tdd.grupo04.rule.collector.BlocksCollector;
import ar.fiuba.tdd.grupo04.rule.collector.ColumnsCollector;
import ar.fiuba.tdd.grupo04.rule.collector.RowsCollector;
import ar.fiuba.tdd.grupo04.rule.condition.AllGreaterThanCondition;
import ar.fiuba.tdd.grupo04.rule.condition.AllLesserThanCondition;
import ar.fiuba.tdd.grupo04.rule.condition.UniqueCondition;
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

        //FIXME - HARDCODE - ONLY FOR TESTING PURPOSES
        IGame game = new Game();
        // Esto se levanta del json de juego
        Board board = new Board(4, 4);
        game.setBoard(board);
        game.addRule(new Rule<>(new ColumnsCollector<>(board), new UniqueCondition()));
        game.addRule(new Rule<>(new RowsCollector<>(board), new UniqueCondition()));
        game.addRule(new Rule<>(new BlocksCollector<>(board, 2, 2), new UniqueCondition()));
        game.addRule(new Rule<>(new AllCollector<>(board, 5), new AllLesserThanCondition()));
        game.addRule(new Rule<>(new AllCollector<>(board, 0), new AllGreaterThanCondition()));

        new GameGui(json, game);
    }

}
