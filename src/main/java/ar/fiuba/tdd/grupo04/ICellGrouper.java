package ar.fiuba.tdd.grupo04.groupers;

import ar.fiuba.tdd.grupo04.grid.ICell;
import ar.fiuba.tdd.grupo04.grid.IGrid;

import java.util.List;

public interface ICellGrouper {
	List<List<ICell>> createCellGroup(IGrid grid);
}