package ar.fiuba.tdd.grupo04.board;

import java.util.Optional;

public interface IBoard<T> {
    void put(T value, Coordinate coordinate);

    Optional<T> get(Coordinate coordinate);

    Integer rowsLength();

    Integer columnsLength();
}
