package ar.fiuba.tdd.grupo04.rule;

import java.util.List;
import java.util.Optional;

public class InputGroup<T> implements IInputGroup<T> {

    private final List<Optional<T>> inputs;

    public InputGroup(List<Optional<T>> inputs) {
        this.inputs = inputs;
    }

    public List<Optional<T>> getInputs() {
        return inputs;
    }
}
