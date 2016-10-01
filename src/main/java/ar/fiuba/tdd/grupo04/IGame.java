package ar.fiuba.tdd.grupo04.game;

import ar.fiuba.tdd.grupo04.grid.IGrid;
import ar.fiuba.tdd.grupo04.grid.IReference;
import ar.fiuba.tdd.grupo04.rules.IRule;

import java.util.ArrayList;

/**
 * Interface for a game.
 */
public interface IGame {
	void fillCell(final Integer xPostition, final Integer yPostition, final Integer value);

	boolean checkRules();

	void addRule(IRule rule);

	void addReference(IReference reference);

	void setGrid(Integer rows, Integer columns);

	void start();
}
