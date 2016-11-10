package ar.fiuba.tdd.grupo04.model.inputs.factories;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.inputs.GraphInput;

public class GraphInputFactory implements IInputFactory {
    @Override
    public GraphInput createInput(Coordinate coordinate) {
        return new GraphInput(coordinate);
    }
}
