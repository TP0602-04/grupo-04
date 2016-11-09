package ar.fiuba.tdd.grupo04.inputs;

import ar.fiuba.tdd.grupo04.board.Coordinate;

public abstract class IInput {
    protected Coordinate coordinate;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public abstract boolean isFilled();
}
