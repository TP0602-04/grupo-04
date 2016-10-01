package ar.fiuba.tdd.grupo04.grid;

import java.util.List;

public interface IGrid {
	void put(Integer value, Integer row, Integer column);
	void addReference(IReference iReference);
	ICell get(Integer row, Integer column);
	List<IReference> getReferences();
	Integer rowsLength();
	Integer columnsLength();
}
