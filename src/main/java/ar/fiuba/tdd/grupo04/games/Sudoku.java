package ar.fiuba.tdd.grupo04.games;

import ar.fiuba.tdd.grupo04.Game;
import ar.fiuba.tdd.grupo04.IGame;
import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.rule.Rule;
import ar.fiuba.tdd.grupo04.rule.collector.AllCollector;
import ar.fiuba.tdd.grupo04.rule.collector.BlocksCollector;
import ar.fiuba.tdd.grupo04.rule.collector.ColumnsCollector;
import ar.fiuba.tdd.grupo04.rule.collector.RowsCollector;
import ar.fiuba.tdd.grupo04.rule.condition.AllGreaterThanCondition;
import ar.fiuba.tdd.grupo04.rule.condition.AllLesserThanCondition;
import ar.fiuba.tdd.grupo04.rule.condition.UniqueCondition;

@SuppressWarnings("CPD-START")
public class Sudoku {
    IGame game;
    private Board board;

    public Sudoku() {
        createGame();
        createBoard();
    }

    private void createGame() {
        game = new Game();
        // Esto se levanta del json de juego
        board = new Board(9, 9);
        game.setBoard(board);
        game.addRule(new Rule<>(new ColumnsCollector<>(board), new UniqueCondition()));
        game.addRule(new Rule<>(new RowsCollector<>(board), new UniqueCondition()));
        game.addRule(new Rule<>(new BlocksCollector<>(board, 3, 3), new UniqueCondition()));
        game.addRule(new Rule<>(new AllCollector<>(board, 10), new AllLesserThanCondition()));
        game.addRule(new Rule<>(new AllCollector<>(board, 0), new AllGreaterThanCondition()));
    }

    private void createBoard() {
        // Esto se levanta del json de escenario
        game.fillCell(new Coordinate(1, 1), 1);
        game.fillCell(new Coordinate(3, 1), 2);
        game.fillCell(new Coordinate(1, 3), 1);
        game.fillCell(new Coordinate(1, 2), 1);
        game.fillCell(new Coordinate(5, 1), 4);
    }

    public void playGame() {
        //while(!game.winCondition() && !game.loseCondition()){
        while (game.checkRules()) {
            //tomar input
            game.fillCell(new Coordinate(2, 7), 8);
        }

    }
}
