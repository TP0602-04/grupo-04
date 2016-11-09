package ar.fiuba.tdd.grupo04.inputs.factories;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.inputs.IInput;

public interface IInputFactory<R extends IInput> {
    R createInput(Coordinate coordinate);
}
