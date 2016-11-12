package ar.fiuba.tdd.grupo04.model.inputs;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;

public class BooleanInput extends IInput {
    private Boolean state;

    public BooleanInput(Coordinate coordinate) {
        this.state = false;
        this.coordinate = coordinate;
    }

    public Boolean getState() {
        return state;
    }

    public void toogleState() {
        state = !state;
    }

    @Override
    public boolean isFilled() {
        return state != null;
    }
}
