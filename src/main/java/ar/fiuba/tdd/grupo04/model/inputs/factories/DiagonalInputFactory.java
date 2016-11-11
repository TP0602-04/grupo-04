package ar.fiuba.tdd.grupo04.model.inputs.factories;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.inputs.DiagonalInput;

public class DiagonalInputFactory implements IInputFactory {
    @Override
    public DiagonalInput createInput(Coordinate coordinate) {
        return new DiagonalInput(coordinate);
    }
}
