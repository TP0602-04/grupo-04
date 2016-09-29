package ar.fiuba.tdd.grupo04;

import java.util.List;

public class AllDifferentRule implements IRule {
	private final List<ICell> cells;

	public AllDifferentRule(final List<ICell> cells) {
		this.cells = cells;
	}

	public boolean check() {
		return cells.stream().map(ICell::getValue).distinct().count() == cells.stream().count();
	}
}
