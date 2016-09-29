package ar.fiuba.tdd.grupo04;

/**
 * Interface for a game.
 */
public interface IGame {
	public void fillCell(final Integer xPostition, final Integer yPostition, final Integer value);

	public boolean checkRules();
}
