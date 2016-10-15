package ar.fiuba.tdd.grupo04.board;

import java.util.Optional;

public interface IInput<T> {
    Optional<T> getValue();

    Coordinate getCoordinate();
}
