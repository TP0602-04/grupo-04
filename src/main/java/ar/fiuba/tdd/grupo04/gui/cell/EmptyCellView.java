package ar.fiuba.tdd.grupo04.gui.cell;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.gui.exception.IllegalInputException;

import java.awt.*;

public class EmptyCellView extends CellView {
    private static final String ILLEGAL_INPUT_ERROR_MSG = "Empty cell can't allocate a value";

    public EmptyCellView(Coordinate coordinate) {
        super(coordinate);
        view.setBackground(Color.black);
    }

    @Override
    public void setValue(String value) throws IllegalInputException {
        throw new IllegalInputException(ILLEGAL_INPUT_ERROR_MSG);
    }

}
