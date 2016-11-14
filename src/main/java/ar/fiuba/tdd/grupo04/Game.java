package ar.fiuba.tdd.grupo04;

import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.board.Slot;
import ar.fiuba.tdd.grupo04.rule.IRule;

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
    public void loadStructure(List<Input> structure) {
        loadAndLockInputs(structure);
    }

    @Override
    public void loadScenario(List<Input> initialValues, List<Slot> slots) {
        loadAndLockInputs(initialValues);
        for (Slot slot : slots) {
            board.addReference(slot);
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

    private void loadAndLockInputs(List<Input> inputs) {
        inputs.forEach(input -> {
            board.fill(input);
            board.lockCell(input.getCoordinate());
        });
    }

}
