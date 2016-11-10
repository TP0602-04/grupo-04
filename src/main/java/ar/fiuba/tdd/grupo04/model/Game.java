package ar.fiuba.tdd.grupo04.model;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.board.IBoard;
import ar.fiuba.tdd.grupo04.model.inputs.IInput;
import ar.fiuba.tdd.grupo04.model.rule.IRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface for a game.
 */
public class Game<R extends IInput> implements IGame<R> {
    private IBoard<R> board;
    private List<IRule> winRules;
    private List<IRule> loseRules;

    public Game() {
        this.winRules = new ArrayList<>();
        this.loseRules = new ArrayList<>();
    }

    @Override
    public R getCell(final Coordinate coordinate) {
        return board.get(coordinate);
    }

    @Override
    public boolean checkWinRules() {
        return winRules.stream().allMatch(IRule::check);
    }

    @Override
    public boolean checkLoseRules() {
        return !loseRules.stream().allMatch(IRule::check);
    }

    @Override
    public void addWinRule(IRule rule) {
        winRules.add(rule);
    }

    @Override
    public void addLoseRule(IRule rule) {
        loseRules.add(rule);
    }

    @Override
    public void setBoard(IBoard board) {
        this.board = board;
    }
}
