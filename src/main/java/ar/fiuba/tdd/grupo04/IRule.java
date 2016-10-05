package ar.fiuba.tdd.grupo04.rules;

import ar.fiuba.tdd.grupo04.grid.IGrid;
import ar.fiuba.tdd.grupo04.groupers.ICellGrouper;

import java.util.List;

public abstract class IRule<T, S> {
	protected ICellGrouper<T, S> cellGrouper;
	protected List<List<T>> cellsGroup;

	public void startRule(IGrid<T, S> grid) {
		cellsGroup = cellGrouper.createCellGroup(grid);
	}

	public boolean check() {
		return cellsGroup.stream().allMatch(cellGroup -> checkList(cellGroup));
	}

	protected abstract boolean checkList(List<T>  cells);
}
