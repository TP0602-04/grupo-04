package ar.fiuba.tdd.pgotuzzo;

import ar.fiuba.tdd.pgotuzzo.rule.IRule;

import java.util.List;

public class Game implements IGame {
    private IBoard board;
    private List<IRule> winRules;
    private List<IRule> loseRules;

    public Game(IBoard board, List<IRule> winRules, List<IRule> loseRules) {
        this.board = board;
        this.winRules = winRules;
        this.loseRules = loseRules;
    }

    @Override
    public void loadScenario(List<Input> initialValues) {
        for (Input input : initialValues) {
            board.fill(input);
            board.lockCell(input.getCoordinate());
        }
    }

    @Override
    public void play(Input input) {
        board.fill(input);
    }

    @Override
    public boolean hasWin() {
        return winRules
                .stream()
                .map(rule -> rule.check(board))
                .reduce(!hasLose(), (b1, b2) -> b1 && b2);
    }

    @Override
    public boolean hasLose() {
        return loseRules
                .stream()
                .map(rule -> !rule.check(board))
                .reduce(false, (b1, b2) -> b1 || b2);
    }

    @Override
    public String printBoard() {
        return board.toString();
    }

}
