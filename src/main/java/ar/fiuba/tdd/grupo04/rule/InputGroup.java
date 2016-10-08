package ar.fiuba.tdd.grupo04.rule;

import java.util.List;

public class InputGroup<T> implements IInputGroup<T> {

    private final List<T> inputs;

    public InputGroup(List<T> inputs) {
        this.inputs = inputs;
    }

    public List<T> getInputs() {
        return inputs;
    }
}
