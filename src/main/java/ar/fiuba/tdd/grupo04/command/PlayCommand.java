package ar.fiuba.tdd.grupo04.command;

import ar.fiuba.tdd.grupo04.Coordinate;
import ar.fiuba.tdd.grupo04.Input;
import ar.fiuba.tdd.grupo04.board.IBoard;

public class PlayCommand implements GameCommand {
    private IBoard board;
    private Input input;
    private Input revertInput;

    public PlayCommand(IBoard board, Input input) {
        this.input = input;
        this.board = board;

        Coordinate coordinate = input.getCoordinate();
        Integer value = board.getCell(coordinate).getValue();
        revertInput = new Input(coordinate, value);
    }

    @Override
    public void execute() {
        board.fill(input);
    }

    @Override
    public void revert() {
        board.fill(revertInput);
    }
}
