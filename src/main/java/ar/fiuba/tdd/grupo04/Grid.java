package ar.fiuba.tdd.grupo04.grid;

import java.util.ArrayList;
import java.util.List;

public class Grid<T, S> implements IGrid<T, S>{
	List<List<T>> cells;
	List<IReference<T, S>> references;

	public Grid(Integer rows, Integer columns){
		this.cells = new ArrayList<>();
		this.initCells(rows, columns);
		this.references = new ArrayList<>();
	}

	private void initCells(Integer rows, Integer columns){
		for(Integer row = 0; row < rows; row++){
			List<T> rowList = new ArrayList<T>();
			this.cells.add(rowList);
			for(Integer column = 0; column < columns; column++){
				rowList.add(null);
			}
		}
	}

	public void put(T value, Integer row, Integer column){
		cells.get(row).set(column, value);
	}

	@Override
	public void addReference(IReference<T, S> iReference) {
		references.add(iReference);
	}

	public T get(Integer row, Integer column){
		return cells.get(row).get(column);
	}

	@Override
	public List<IReference<T, S>> getReferences() {
		return references;
	}

	@Override
	public Integer rowsLength() {
		return this.cells.size();
	}

	@Override
	public Integer columnsLength() {
		return this.cells.get(0).size();
	}
}
