package ar.fiuba.tdd.grupo04.grid;

import java.util.List;

public class ReferenceBuilder<T, S> {
	private Integer rowOffset = 0;
	private Integer columnOffset = 0;
	private Integer rowLarge = 1;
	private Integer columnLarge = 1;
	private Integer referencedValue = 0;

	public IReference<T, S> createReference() {
		final Reference reference = new Reference(rowOffset, columnOffset, rowLarge, columnLarge, referencedValue);
		clear();
		return reference;
	}

	private void clear() {
		rowOffset = 0;
		columnOffset = 0;
		rowLarge = 1;
		columnLarge = 1;
		referencedValue = 0;
	}

	public ReferenceBuilder rowOffset(Integer newRowOffset) {
		rowOffset = newRowOffset;
		return this;
	}

	public ReferenceBuilder columnOffset(Integer newColumnOffsett) {
		columnOffset = newColumnOffsett;
		return this;
	}

	public ReferenceBuilder rowLarge(Integer newRowLarge) {
		rowLarge = newRowLarge;
		return this;
	}

	public ReferenceBuilder columnLarge(Integer newColumnLarge) {
		columnLarge = newColumnLarge;
		return this;
	}

	public ReferenceBuilder referencedValue(Integer newReferencedValue) {
		referencedValue = newReferencedValue;
		return this;
	}
}
