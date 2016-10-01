package ar.fiuba.tdd.grupo04.sudoku;

import ar.fiuba.tdd.grupo04.game.Game;
import ar.fiuba.tdd.grupo04.game.IGame;
import ar.fiuba.tdd.grupo04.groupers.ColumnsCellGrouper;
import ar.fiuba.tdd.grupo04.rules.AllDifferentRule;

public class Sudoku {
	IGame game;

	public Sudoku() {
		createGame();
		createBoard();
	}

	private void createGame() {
		game = new Game();
		// Esto se levanta del json de juego
		game.setGrid(9, 9);
		game.addRule(new AllDifferentRule(new ColumnsCellGrouper()));
//		game.addRule(new AllDifferentRule(new RowCellGrouper()));
//		game.addRule(new AllDifferentRule(new BlockCellGrouper()));
//		game.addRule(new AllLesserThanRule(new AllCellGrouper(),10));
//		game.addRule(new AllGreaterThanRule(new AllCellGrouper(),0));
	}

	private void createBoard() {
		// Esto se levanta del json de escenario
		game.fillCell(1, 1, 1);
		game.fillCell(3, 1, 2);
		game.fillCell(1, 3, 1);
		game.fillCell(1, 2, 1);
		game.fillCell(5, 1, 4);
	}

	public void playGame() {
		game.start();

		// aca estaria el loop con el input
		// fillCell tendria q fijarse q no esta puesto ya o algo asi
		while (game.checkRules()) {
			game.fillCell(2, 7, 8);
		}
	}
}
