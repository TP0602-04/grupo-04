package ar.fiuba.tdd.grupo04.games;

import ar.fiuba.tdd.grupo04.board.Coordinate;

public class ValuedCoordinate<T> {
    private final Coordinate coordinate;
    private final T value;

    public ValuedCoordinate(Coordinate coordinate, T value) {
        this.coordinate = coordinate;
        this.value = value;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public T getValue() {
        return value;
    }
}
