package ar.fiuba.tdd.grupo04.sudoku;

import ar.fiuba.tdd.grupo04.GameBuilder;
import ar.fiuba.tdd.grupo04.Grouper;
import ar.fiuba.tdd.grupo04.ICellGrouperFactory;

public class Sudoku {
	public Sudoku() {
		final GameBuilder gameBuilder = new GameBuilder();
		gameBuilder.setGridSize(9,9);

//		ICellGrouperFactory.createCellGrouper(Grouper.COLUMN)
//		gameBuilder.setRules(9,9);
	}
}
