package ar.fiuba.tdd.grupo04.rules;

import ar.fiuba.tdd.grupo04.groupers.ICellGrouper;

import java.util.List;

public class AllDifferentRule<T, S> extends IRule<T, S> {

	public AllDifferentRule(ICellGrouper cellGrouper) {
		this.cellGrouper = cellGrouper;
	}

	@Override
	public boolean checkList(List<T>  cells) {
		return cells.stream().distinct().count() == cells.stream().count();
	}
}
