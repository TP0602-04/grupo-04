package ar.fiuba.tdd.grupo04.games;

import ar.fiuba.tdd.grupo04.Game;
import ar.fiuba.tdd.grupo04.IGame;
import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.rule.IRule;
import ar.fiuba.tdd.grupo04.rule.Rule;
import ar.fiuba.tdd.grupo04.rule.collector.AllCollector;
import ar.fiuba.tdd.grupo04.rule.collector.BlocksCollector;
import ar.fiuba.tdd.grupo04.rule.collector.ColumnsCollector;
import ar.fiuba.tdd.grupo04.rule.collector.RowsCollector;
import ar.fiuba.tdd.grupo04.rule.condition.AllFilledCondition;
import ar.fiuba.tdd.grupo04.rule.condition.AllGreaterThanCondition;
import ar.fiuba.tdd.grupo04.rule.condition.AllLesserThanCondition;
import ar.fiuba.tdd.grupo04.rule.condition.UniqueCondition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        game.fillCell(new Coordinate(0, 3), 6);
        game.fillCell(new Coordinate(0, 4), 5);

        game.fillCell(new Coordinate(1, 1), 7);
        game.fillCell(new Coordinate(1, 3), 3);
        game.fillCell(new Coordinate(1, 4), 8);
        game.fillCell(new Coordinate(1, 6), 2);

        game.fillCell(new Coordinate(2, 0), 2);
        game.fillCell(new Coordinate(2, 1), 8);
        game.fillCell(new Coordinate(2, 2), 5);
        game.fillCell(new Coordinate(2, 4), 4);

        game.fillCell(new Coordinate(4, 0), 7);
        game.fillCell(new Coordinate(4, 2), 4);
        game.fillCell(new Coordinate(4, 3), 8);
        game.fillCell(new Coordinate(4, 4), 2);
        game.fillCell(new Coordinate(4, 5), 6);
        game.fillCell(new Coordinate(4, 6), 5);
        game.fillCell(new Coordinate(4, 7), 9);
        game.fillCell(new Coordinate(4, 8), 3);

        game.fillCell(new Coordinate(5, 4), 1);
        game.fillCell(new Coordinate(5, 5), 7);
        game.fillCell(new Coordinate(5, 6), 6);
        game.fillCell(new Coordinate(5, 7), 2);
        game.fillCell(new Coordinate(5, 8), 4);

        game.fillCell(new Coordinate(6, 0), 5);
        game.fillCell(new Coordinate(6, 5), 4);
        game.fillCell(new Coordinate(6, 8), 6);

        game.fillCell(new Coordinate(7, 0), 3);
        game.fillCell(new Coordinate(7, 4), 6);

        game.fillCell(new Coordinate(8, 0), 4);
        game.fillCell(new Coordinate(8, 3), 2);
        game.fillCell(new Coordinate(8, 4), 3);
        game.fillCell(new Coordinate(8, 6), 8);
    }

    public void playGame() throws IOException {
        IRule fullBoard = new Rule<>(new AllCollector<>(board), new AllFilledCondition());
        String input;
        InputStreamReader isr = new InputStreamReader(System.in, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        while (!fullBoard.check() && game.checkRules()) {
            System.out.println("ingrese fila,columna,valor");
            input = br.readLine();
            if(!"".equals(input)){
                Integer row = Integer.parseInt(input.substring(0, 1)) - 1;
                Integer col = Integer.parseInt(input.substring(2, 3)) - 1;
                Integer value = Integer.parseInt(input.substring(4));
                game.fillCell(new Coordinate(row, col), value);
            }
        }
        if (game.checkRules()) {
            System.out.println("GANASTE");
        } else {
            System.out.println("PERDISTE");
        }
    }
}
