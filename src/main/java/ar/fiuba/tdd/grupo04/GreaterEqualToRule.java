package ar.fiuba.tdd.grupo04;

import java.util.List;

public class GreaterEqualToRule implements IRule {
	private final List<ICell> cells;
	private final Integer value;

	public GreaterEqualToRule(final List<ICell> cells, final Integer value) {
		this.cells = cells;
		this.value = value;
	}

	public boolean check() {
		return value <= cells.stream().mapToInt(ICell::getValue).min().getAsInt();
	}
}
