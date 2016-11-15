package ar.fiuba.tdd.grupo04.model.inputs.factories;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.inputs.BooleanInput;
import ar.fiuba.tdd.grupo04.model.inputs.NumericInput;

public class BooleanInputFactory implements IInputFactory {
    @Override
    public BooleanInput createInput(Coordinate coordinate) {
        return new BooleanInput(coordinate);
    }
}
