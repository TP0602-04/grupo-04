package ar.fiuba.tdd.grupo04.inputs;

import ar.fiuba.tdd.grupo04.board.Coordinate;

public class ValuedCoordinate {
    private final Coordinate coordinate;
    private final Integer value;

    public ValuedCoordinate(Coordinate coordinate, Integer value) {
        this.coordinate = coordinate;
        this.value = value;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Integer getValue() {
        return value;
    }
}
