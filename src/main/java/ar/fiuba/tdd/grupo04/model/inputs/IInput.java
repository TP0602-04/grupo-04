package ar.fiuba.tdd.grupo04.model.inputs;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;

public abstract class IInput {
    protected Coordinate coordinate;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public abstract boolean isFilled();
}
