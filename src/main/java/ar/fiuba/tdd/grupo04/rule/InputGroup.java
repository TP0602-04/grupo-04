package ar.fiuba.tdd.grupo04.rule;

import ar.fiuba.tdd.grupo04.board.IInput;

import java.util.List;
import java.util.Optional;

public class InputGroup<T> implements IInputGroup<T> {

    private final List<IInput<T>> inputs;

    public InputGroup(List<IInput<T>> inputs) {
        this.inputs = inputs;
    }

    public List<IInput<T>> getInputs() {
        return inputs;
    }
}
