package ar.fiuba.tdd.grupo04.model.inputs;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;

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
