package ar.fiuba.tdd.grupo04;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Game implements IGame {
	private IGrid grid;
	private List<IRule> rules;


	public void fillCell(final Integer xPostition, final Integer yPostition, final Integer value) {
		grid.put(value, xPostition, yPostition);

	}

	public boolean checkRules() {
		return rules.stream().allMatch(IRule::check);
	}

	public void setRules(List<IRule> rules) {
		this.rules = rules;
	}

	public void setGrid(IGrid grid) {
		this.grid = grid;
	}
}
