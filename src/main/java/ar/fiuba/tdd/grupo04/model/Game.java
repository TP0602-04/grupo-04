package ar.fiuba.tdd.grupo04.model;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.board.IBoard;
import ar.fiuba.tdd.grupo04.model.inputs.IInput;
import ar.fiuba.tdd.grupo04.model.inputs.IInputModification;
import ar.fiuba.tdd.grupo04.model.rule.IRule;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Interface for a game.
 */
public class Game implements IGame {
    private IBoard board;
    private List<IRule> winRules;
    private List<IRule> loseRules;
    private Deque<Pair<Coordinate, IInputModification>> previousMoves = new ArrayDeque<>();

    public Game() {
        this.winRules = new ArrayList<>();
        this.loseRules = new ArrayList<>();
    }

    @Override
    public void addInputModification(Coordinate coordinate, IInputModification inputModification) {
        previousMoves.push(new Pair<>(coordinate, inputModification.makeModification(board.get(coordinate))));
    }

    @Override
    public void previousModification() {
        final Pair<Coordinate, IInputModification> lastModification = previousMoves.pop();
        lastModification.getValue().makeModification(board.get(lastModification.getKey()));
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
