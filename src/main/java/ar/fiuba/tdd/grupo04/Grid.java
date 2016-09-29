package ar.fiuba.tdd.grupo04;

import java.util.ArrayList;
import java.util.List;

public class Grid implements IGrid{
	List<List<ICell>> cells;

	public Grid(Integer rows, Integer columns){
		this.cells = new ArrayList<List<ICell>>();
		this.initCells(rows, columns);
	}

	private void initCells(Integer rows, Integer columns){
		for(Integer row = 0; row < rows; row++){
			List<ICell> rowList = new ArrayList<ICell>();
			this.cells.add(rowList);
			for(Integer column = 0; column < columns; column++){
				rowList.add(new NumberCell());
			}
		}
	}

	public void put(Integer value, Integer row, Integer column){
		cells.get(row).get(column).setValue(value);
	}

	public ICell get(Integer row, Integer column){
		return cells.get(row).get(column);
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
