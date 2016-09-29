package ar.fiuba.tdd.grupo04;

import java.util.List;

public interface ICellGrouper {
	List<List<ICell>> createCellGroup(IGrid grid);
}
