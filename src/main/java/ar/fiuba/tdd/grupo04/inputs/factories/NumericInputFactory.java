package ar.fiuba.tdd.grupo04.inputs.factories;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.inputs.NumericInput;

public class NumericInputFactory implements IInputFactory {
    @Override
    public NumericInput createInput(Coordinate coordinate) {
        return new NumericInput(coordinate);
    }
}
