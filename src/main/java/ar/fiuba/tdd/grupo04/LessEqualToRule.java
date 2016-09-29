package ar.fiuba.tdd.grupo04;

import java.util.List;

public class LessEqualToRule implements IRule {
	private final List<ICell> cells;
	private final Integer value;

	public LessEqualToRule(final List<ICell> cells, final Integer value) {
		this.cells = cells;
		this.value = value;
	}

	public boolean check() {
		return value >= cells.stream().mapToInt(ICell::getValue).max().getAsInt();
	}
}
