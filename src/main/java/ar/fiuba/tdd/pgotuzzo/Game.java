package ar.fiuba.tdd.pgotuzzo;

import ar.fiuba.tdd.pgotuzzo.rule.IRule;

import java.util.List;

public class Game implements IGame {
    private Board board;
    private List<IRule> winRules;
    private List<IRule> loseRules;

    public Game(Board board, List<IRule> winRules, List<IRule> loseRules) {
        this.board = board;
        this.winRules = winRules;
        this.loseRules = loseRules;
    }

    @Override
    public void play(Input input) {
    }

    @Override
    public boolean hasWin() {
        return false;
    }

    @Override
    public boolean hasLose() {
        return false;
    }

}
