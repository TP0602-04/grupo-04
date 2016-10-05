package ar.fiuba.tdd.grupo04.grid;

import java.util.List;

public interface IGrid<T, S>  {
	void put(T value, Integer row, Integer column);
	void addReference(IReference<T, S> iReference);
	T get(Integer row, Integer column);
	List<IReference<T, S>> getReferences();
	Integer rowsLength();
	Integer columnsLength();
}
