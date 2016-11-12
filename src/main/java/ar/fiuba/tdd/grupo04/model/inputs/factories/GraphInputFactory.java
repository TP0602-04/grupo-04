package ar.fiuba.tdd.grupo04.model.inputs.factories;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.inputs.GraphInput;
import ar.fiuba.tdd.grupo04.model.inputs.IInput;

public class GraphInputFactory implements IInputFactory<IInput> {
    @Override
    public GraphInput createInput(Coordinate coordinate) {
        return new GraphInput(coordinate);
    }
}
