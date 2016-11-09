package ar.fiuba.tdd.grupo04;


import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.inputs.IInput;
import ar.fiuba.tdd.grupo04.rule.IRule;

/**
 * Interface for a game.
 */
public interface IGame<R extends IInput> {
    R getCell(final Coordinate coordinate);

    boolean checkWinRules();

    boolean checkLoseRules();

    void addWinRule(IRule rule);

    void addLoseRule(IRule rule);

    void setBoard(IBoard<R> board);
}
