package ar.fiuba.tdd.grupo04.rule;

import ar.fiuba.tdd.grupo04.board.IInput;

import java.util.List;
import java.util.Optional;

public class ValuedInputGroup<T, S> implements IValuedInputGroup<T, S> {
    private final S value;
    private final List<IInput<T>> inputs;

    public ValuedInputGroup(S value, List<IInput<T>> inputs) {
        this.value = value;
        this.inputs = inputs;
    }

    @Override
    public List<IInput<T>> getInputs() {
        return inputs;
    }

    @Override
    public S getValue() {
        return value;
    }
}
