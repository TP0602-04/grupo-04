package ar.fiuba.tdd.grupo04.inputs.factories;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.inputs.GraphInput;

public class GraphInputFactory implements IInputFactory {
    @Override
    public GraphInput createInput(Coordinate coordinate) {
        return new GraphInput(coordinate);
    }
}
