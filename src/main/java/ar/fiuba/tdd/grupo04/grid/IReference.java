package ar.fiuba.tdd.grupo04.grid;

import java.util.List;

public interface IReference<T, S> {
	List<T> getReferencedCells(final IGrid<T, S> iGrid);
	S getReferencedValue();
}
