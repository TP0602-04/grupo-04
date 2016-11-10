package ar.fiuba.tdd.grupo04.model.inputs.factories;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.inputs.NumericInput;

public class NumericInputFactory implements IInputFactory {
    @Override
    public NumericInput createInput(Coordinate coordinate) {
        return new NumericInput(coordinate);
    }
}
