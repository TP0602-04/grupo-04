package ar.fiuba.tdd.grupo04.game;

import ar.fiuba.tdd.grupo04.grid.Grid;
import ar.fiuba.tdd.grupo04.grid.IGrid;
import ar.fiuba.tdd.grupo04.grid.IReference;
import ar.fiuba.tdd.grupo04.rules.IRule;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {
	private IGrid grid;
	final private List<IRule> rules;

	public Game() {
		this.rules = new ArrayList<>();
	}

	public void fillCell(final Integer xPostition, final Integer yPostition, final Integer value) {
		grid.put(value, xPostition, yPostition);
	}

	public boolean checkRules() {
		return rules.stream().allMatch(IRule::check);
	}

	public void addRule(IRule rule) {
		rules.add(rule);
	}

	public void addReference(IReference reference) {
		grid.addReference(reference);
	}

	public void setGrid(Integer rows, Integer columns) {
		this.grid = new Grid(rows, columns);
	}

	public void start() {
		rules.forEach(r -> r.startRule(grid));
	}
}
