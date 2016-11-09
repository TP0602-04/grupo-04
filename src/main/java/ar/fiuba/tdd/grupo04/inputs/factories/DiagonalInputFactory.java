package ar.fiuba.tdd.grupo04.inputs.factories;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.inputs.DiagonalInput;

public class DiagonalInputFactory implements IInputFactory {
    @Override
    public DiagonalInput createInput(Coordinate coordinate) {
        return new DiagonalInput(coordinate);
    }
}
