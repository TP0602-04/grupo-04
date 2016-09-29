package ar.fiuba.tdd.grupo04;

public interface IGrid {
	void put(Integer value, Integer row, Integer column);
	ICell get(Integer row, Integer column);
	Integer rowsLength();
	Integer columnsLength();
}
