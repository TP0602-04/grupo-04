package ar.fiuba.tdd.grupo04;

import java.util.ArrayList;
import java.util.List;

public class Grid implements IGrid{
	private List<List<ICell>> cells;

	public Grid(Integer rows, Integer columns){
		this.initCells(rows, columns);
	}

	private void initCells(Integer rows, Integer columns){
		this.cells = new ArrayList<List<ICell>>();
		for(Integer row = 0; row < rows; row++){
			List<ICell> rowList = new ArrayList<ICell>();
			this.cells.add(rowList);
			for(Integer column = 0; column < columns; column++){
				rowList.add(new NumberCell());
			}
		}
	}

	@Override
	public void put(Integer value, Integer row, Integer column){
		cells.get(row).get(column).setValue(value);
	}

	@Override
	public ICell get(Integer row, Integer column){
		return cells.get(row).get(column);
	}

	@Override
	public List<ICell> getBlock(Integer row, Integer column, Integer rowsLength, Integer columnsLength) {
		List<ICell> block = new ArrayList<ICell>();
		for(Integer i = 0; i < columnsLength; i++) {
			for(Integer j = 0; j < rowsLength; j++) {
				block.add(this.cells.get(i + row).get(j + column));
			}
		}
		return block;
	}

	@Override
	public Integer rowsLength() {
		return this.cells.get(0).size();
	}

	@Override
	public Integer columnsLength() {
		return this.cells.size();
	}
}
