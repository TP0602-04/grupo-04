package ar.fiuba.tdd.grupo04.board;

import ar.fiuba.tdd.grupo04.inputs.IInput;

public interface IBoard<R extends IInput> {
    R get(Coordinate coordinate);

    Integer rowsLength();

    Integer columnsLength();
}
