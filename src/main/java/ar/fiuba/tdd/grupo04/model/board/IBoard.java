package ar.fiuba.tdd.grupo04.model.board;

import ar.fiuba.tdd.grupo04.model.inputs.IInput;

public interface IBoard {
    IInput get(Coordinate coordinate);

    Integer rowsLength();

    Integer columnsLength();
}
