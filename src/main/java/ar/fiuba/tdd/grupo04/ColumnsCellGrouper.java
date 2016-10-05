package ar.fiuba.tdd.grupo04.groupers;

import ar.fiuba.tdd.grupo04.grid.IGrid;

import java.util.ArrayList;
import java.util.List;

public class ColumnsCellGrouper<T, S> implements ICellGrouper<T, S> {
	@Override
	public List<List<T>> createCellGroup(IGrid<T, S> grid) {
		Integer rowLength = grid.rowsLength();
		Integer colLength = grid.columnsLength();
		List<List<T>> columns = new ArrayList<List<T>>();
		for(Integer i = 0; i < colLength; i++){
			List<T> column = new ArrayList<T>();
			columns.add(column);
			for(Integer j = 0; j < rowLength; j++){
				column.add(grid.get(j, i));
			}
		}
		return columns;
	}
}
