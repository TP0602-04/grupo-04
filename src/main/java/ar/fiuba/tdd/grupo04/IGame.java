package ar.fiuba.tdd.grupo04.game;

import ar.fiuba.tdd.grupo04.grid.IGrid;
import ar.fiuba.tdd.grupo04.grid.IReference;
import ar.fiuba.tdd.grupo04.rules.IRule;

import java.util.ArrayList;

/**
 * Interface for a game.
 */
public interface IGame<T, S>{
	void fillCell(final Integer xPostition, final Integer yPostition, final T value);

	boolean checkRules();

	void addRule(IRule<T, S> rule);

	void addReference(IReference<T, S> reference);

	void setGrid(Integer rows, Integer columns);

	void start();
}
