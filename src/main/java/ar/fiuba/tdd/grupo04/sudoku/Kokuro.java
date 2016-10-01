package ar.fiuba.tdd.grupo04.sudoku;

import ar.fiuba.tdd.grupo04.game.Game;
import ar.fiuba.tdd.grupo04.game.IGame;
import ar.fiuba.tdd.grupo04.grid.ReferenceBuilder;
import ar.fiuba.tdd.grupo04.groupers.ColumnsCellGrouper;
import ar.fiuba.tdd.grupo04.groupers.RefenceCellGrouper;
import ar.fiuba.tdd.grupo04.rules.AllDifferentRule;
import ar.fiuba.tdd.grupo04.rules.SumValueRule;

public class Kokuro {
	IGame game;

	public Kokuro() {
		createGame();
		createBoard();
	}

	private void createGame() {
		game = new Game();
		// Esto se levanta del json de juego
		game.setGrid(8, 8);
		final RefenceCellGrouper refenceCellGrouper = new RefenceCellGrouper();
		game.addRule(new AllDifferentRule(refenceCellGrouper));
		game.addRule(new SumValueRule(refenceCellGrouper));
//		game.addRule(new AllLesserThanRule(new AllCellGrouper(),10));
//		game.addRule(new AllGreaterThanRule(new AllCellGrouper(),0));
	}

	private void createBoard() {
		game.fillCell(1, 1, 1);
		game.fillCell(3, 1, 2);
		game.fillCell(5, 1, 4);
		// Aca van todos los grupos que suman numeros;
		// Esto se levanta del json de escenario
		final ReferenceBuilder referenceBuilder = new ReferenceBuilder();
		game.addReference(referenceBuilder.rowOffset(2).columnLarge(3).referencedValue(7).createReference());
		game.addReference(referenceBuilder.columnLarge(6).columnOffset(4).rowOffset(1).referencedValue(8).createReference());
		game.addReference(referenceBuilder.rowOffset(1).rowLarge(6).referencedValue(10).createReference());
		game.addReference(referenceBuilder.columnLarge(2).referencedValue(8).createReference());
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
