package ar.fiuba.tdd.grupo04.board;

import java.util.Optional;

public interface IBoard<T> {
    void put(T value, Coordinate coordinate);

    IInput<T> get(Coordinate coordinate);

    Integer rowsLength();

    Integer columnsLength();
}
