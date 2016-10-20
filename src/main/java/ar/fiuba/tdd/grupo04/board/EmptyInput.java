package ar.fiuba.tdd.grupo04.board;

import java.util.Optional;

public class EmptyInput<T> implements IInput<T> {
    private final Coordinate coordinate;

    public EmptyInput(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public Optional<T> getValue() {
        throw new SecurityException();
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public boolean isBlocked() {
        return true;
    }
}
