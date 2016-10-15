package ar.fiuba.tdd.grupo04.board;

import java.util.Optional;

public class Input<T> implements IInput<T> {
    private final Optional<T> value;
    private final Coordinate coordinate;

    public Input(Optional<T> value, Coordinate coordinate) {
        this.value = value;
        this.coordinate = coordinate;
    }

    @Override
    public Optional<T> getValue() {
        return value;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }
}
