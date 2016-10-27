package ar.fiuba.tdd.grupo04.board;

import java.util.Optional;

public class Input<T> implements IInput<T> {
    private final T value;
    private final Coordinate coordinate;

    public Input(T value, Coordinate coordinate) {
        this.value = value;
        this.coordinate = coordinate;
    }

    @Override
    public Optional<T> getValue() {
        return  Optional.ofNullable(value);
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }
}
