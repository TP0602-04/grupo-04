package ar.fiuba.tdd.grupo04.grid;

import java.util.List;

public interface IReference {
	List<ICell> getReferencedCells(final IGrid iGrid);
	Integer getReferencedValue();
}
