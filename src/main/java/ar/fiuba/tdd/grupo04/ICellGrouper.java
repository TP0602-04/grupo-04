package ar.fiuba.tdd.grupo04.groupers;

import ar.fiuba.tdd.grupo04.grid.IGrid;

import java.util.List;

public interface ICellGrouper<T, S> {
	List<List<T>> createCellGroup(IGrid<T, S> grid);
}
