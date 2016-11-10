package ar.fiuba.tdd.grupo04.model.inputs.factories;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.inputs.IInput;

public interface IInputFactory<R extends IInput> {
    R createInput(Coordinate coordinate);
}
