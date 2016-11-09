package ar.fiuba.tdd.grupo04.rule;

import ar.fiuba.tdd.grupo04.inputs.IInput;

import java.util.List;

public class ValuedInputGroup<R extends IInput, S> implements IValuedInputGroup<R, S> {
    private final S value;
    private final List<R> inputs;

    public ValuedInputGroup(S value, List<R> inputs) {
        this.value = value;
        this.inputs = inputs;
    }

    @Override
    public List<R> getInputs() {
        return inputs;
    }

    @Override
    public S getValue() {
        return value;
    }
}
