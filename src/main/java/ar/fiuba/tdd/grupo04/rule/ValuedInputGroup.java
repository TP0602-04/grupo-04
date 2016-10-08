package ar.fiuba.tdd.grupo04.rule;

import java.util.List;

public class ValuedInputGroup<T, S> implements IValuedInputGroup<T, S> {
    private final S value;
    private final List<T> inputs;

    public ValuedInputGroup(S value, List<T> inputs) {
        this.value = value;
        this.inputs = inputs;
    }

    public List<T> getInputs() {
        return inputs;
    }

    @Override
    public S getValue() {
        return value;
    }
}
