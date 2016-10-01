package ar.fiuba.tdd.grupo04.rules;

import ar.fiuba.tdd.grupo04.grid.ICell;
import ar.fiuba.tdd.grupo04.grid.IGrid;
import ar.fiuba.tdd.grupo04.groupers.ICellGrouper;

import java.util.List;

public class AllDifferentRule extends IRule {

	public AllDifferentRule(ICellGrouper cellGrouper) {
		this.cellGrouper = cellGrouper;
	}

	@Override
	public boolean checkList(List<ICell>  cells) {
		return cells.stream().map(ICell::getValue).distinct().count() == cells.stream().count();
	}
}
