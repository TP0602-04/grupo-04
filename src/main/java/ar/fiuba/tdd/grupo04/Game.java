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
    private List<IRule> rules;

    public Game() {
        this.rules = new ArrayList<>();
    }

    @Override
    public void fillCell(final Coordinate coordinate, T value) {
        board.put(value, coordinate);
    }

    @Override
    public boolean checkRules() {
        return rules.stream().allMatch(IRule::check);
    }

    @Override
    public void addRule(IRule rule) {
        rules.add(rule);
    }

    @Override
    public void setBoard(IBoard board) {
        this.board = board;
    }
}
