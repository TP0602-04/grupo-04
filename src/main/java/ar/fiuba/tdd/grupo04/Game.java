package ar.fiuba.tdd.grupo04;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.rule.IRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface for a game.
 */
public class Game<T, S> implements IGame<T, S> {
    private IBoard<T> board;
    private List<IRule> winRules;
    private List<IRule> loseRules;

    public Game() {
        this.winRules = new ArrayList<>();
        this.loseRules = new ArrayList<>();
    }

    @Override
    public void fillCell(final Coordinate coordinate, T value) {
        //do nothing if cell is already filled
        board.put(value, coordinate);
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
