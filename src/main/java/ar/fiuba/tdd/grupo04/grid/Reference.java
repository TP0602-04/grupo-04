package ar.fiuba.tdd.grupo04.grid;

import java.util.ArrayList;
import java.util.List;

public class Reference<T, S> implements IReference<T, S> {
	private final Integer rowOffset;
	private final Integer columnOffset;
	private final Integer rowLarge;
	private final Integer columnLarge;
	private final S referencedValue;

	public Reference(Integer rowOffset, Integer columnOffset, Integer rowLarge, Integer columnLarge, S referencedValue) {
		this.rowOffset = rowOffset;
		this.columnOffset = columnOffset;
		this.rowLarge = rowLarge;
		this.columnLarge = columnLarge;
		this.referencedValue = referencedValue;
	}

	@Override
	public List<T> getReferencedCells(final IGrid<T, S> iGrid) {
		final ArrayList<T> referencedCells = new ArrayList<>();
		for (int i = rowOffset; i < (rowOffset + rowLarge); i++) {
			for (int j = columnOffset; j < (columnOffset + columnLarge); j++) {
				referencedCells.add(iGrid.get(i, j));
			}
		}
		return referencedCells;
	}

	@Override
	public S getReferencedValue() {
		return referencedValue;
	}
}
