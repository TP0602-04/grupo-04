package ar.fiuba.tdd.grupo04.groupers;

import ar.fiuba.tdd.grupo04.grid.IGrid;

import java.util.List;

public interface IRefenceCellGrouper<T, S> extends  ICellGrouper<T, S> {
	List<S> getReferencedValues(IGrid<T, S> grid);
}
