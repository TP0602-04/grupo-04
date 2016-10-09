package ar.fiuba.tdd.grupo04.rule;

import java.util.List;
import java.util.Optional;

public class ValuedInputGroup<T, S> implements IValuedInputGroup<T, S> {
    private final S value;
    private final List<Optional<T>> inputs;

    public ValuedInputGroup(S value, List<Optional<T>> inputs) {
        this.value = value;
        this.inputs = inputs;
    }

    public List<Optional<T>> getInputs() {
        return inputs;
    }

    @Override
    public S getValue() {
        return value;
    }
}
