package ar.fiuba.tdd.grupo04;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Game implements IGame {
	final private IGrid grid;
	final private List<IRule> rules;

	public Game(final IGrid iGrid, final List<IRule> iRule) {
		this.grid = iGrid;
		this.rules = iRule;
	}

	public void fillCell(final Integer xPostition, final Integer yPostition, final Integer value) {
		grid.fillCell(xPostition, yPostition, value);

	}

	public boolean checkRules() {
		return rules.stream().allMatch(IRule::check);
	}
}
