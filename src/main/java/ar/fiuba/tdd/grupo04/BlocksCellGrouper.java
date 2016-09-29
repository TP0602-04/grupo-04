package ar.fiuba.tdd.grupo04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manuelcruz on 29/09/2016.
 */
public class BlocksCellGrouper implements ICellGrouper {
	private Integer rowsLength;
	private Integer columnsLength;

	public BlocksCellGrouper(Integer rowsLength, Integer columnsLength) {
		this.rowsLength = columnsLength;
		this.columnsLength = rowsLength;
	}

	@Override
	public List<List<ICell>> createCellGroup(IGrid grid) {
		Integer gridRowsLength = grid.rowsLength();
		Integer gridColumnsLength = grid.columnsLength();
		List<List<ICell>> blocks = new ArrayList<List<ICell>>();
		if(gridRowsLength % this.rowsLength == 0 && gridColumnsLength % this.columnsLength == 0) {
			Integer xBlocks = gridRowsLength / this.rowsLength;
			Integer yBlocks = gridColumnsLength / this.columnsLength;
			for(Integer i = 0; i < yBlocks; i++){
				for(Integer j = 0; j < xBlocks; j++){
					blocks.add(grid.getBlock(i * this.columnsLength, j * this.rowsLength, this.rowsLength, this.columnsLength));
				}
			}
		}
		return blocks;
	}
}
