package ar.fiuba.tdd.grupo04.rules;

import ar.fiuba.tdd.grupo04.grid.ICell;
import ar.fiuba.tdd.grupo04.grid.IGrid;
import ar.fiuba.tdd.grupo04.groupers.ICellGrouper;

import java.util.List;

public abstract class IRule {
	protected ICellGrouper cellGrouper;
	protected List<List<ICell>> cellsGroup;

	public void startRule(IGrid grid) {
		cellsGroup = cellGrouper.createCellGroup(grid);
	}

	public boolean check() {
		return cellsGroup.stream().allMatch(cellGroup -> checkList(cellGroup));
	}

	protected abstract boolean checkList(List<ICell>  cells);
}
