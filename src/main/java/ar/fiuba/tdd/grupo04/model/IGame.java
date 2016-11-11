package ar.fiuba.tdd.grupo04.model;


import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.board.IBoard;
import ar.fiuba.tdd.grupo04.model.inputs.IInputModification;
import ar.fiuba.tdd.grupo04.model.rule.IRule;

/**
 * Interface for a game.
 */
public interface IGame {
    void addInputModification(final Coordinate coordinate, IInputModification inputModification);

    void previousModification();

    boolean checkWinRules();

    boolean checkLoseRules();

    void addWinRule(IRule rule);

    void addLoseRule(IRule rule);

    void setBoard(IBoard board);
}
