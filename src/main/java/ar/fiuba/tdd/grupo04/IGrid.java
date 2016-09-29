package ar.fiuba.tdd.grupo04;

import java.util.List;

public interface IGrid {
	void put(Integer value, Integer row, Integer column);
	ICell get(Integer row, Integer column);
	Integer rowsLength();
	Integer columnsLength();
	List<ICell> getBlock(Integer row, Integer column, Integer rowsLength, Integer columnsLength);
}
