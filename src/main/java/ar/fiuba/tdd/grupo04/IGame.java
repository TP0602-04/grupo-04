package ar.fiuba.tdd.grupo04;


import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.rule.IRule;

/**
 * Interface for a game.
 */
public interface IGame<T, S> {
    void fillCell(final Coordinate coordinate, final T value);

    void blockCell(final Coordinate coordinate);

    boolean checkWinRules();

    boolean checkLoseRules();

    void addWinRule(IRule rule);

    void addLoseRule(IRule rule);

    void setBoard(IBoard board);
}
