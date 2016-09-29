package ar.fiuba.tdd.grupo04;

import java.util.List;

public class SumValueRule implements IRule {
	private final List<ICell> cells;
	private final Integer value;

	public SumValueRule(final List<ICell> cells, final Integer value) {
		this.cells = cells;
		this.value = value;
	}

	public boolean check() {
		return value.equals(cells.stream().mapToInt(ICell::getValue).sum());
	}
}
