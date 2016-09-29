package ar.fiuba.tdd.grupo04;

import java.util.ArrayList;
import java.util.List;

public class ColumnsCellGrouper implements ICellGrouper {
	@Override
	public List<List<ICell>> createCellGroup(IGrid grid) {
		Integer rowLength = grid.rowsLength();
		Integer colLength = grid.columnsLength();
		List<List<ICell>> columns = new ArrayList<List<ICell>>();
		for(Integer i = 0; i < colLength; i++){
			List<ICell> column = new ArrayList<ICell>();
			columns.add(column);
			for(Integer j = 0; j < rowLength; j++){
				column.add(grid.get(j, i));
			}
		}
		return columns;
	}
}
