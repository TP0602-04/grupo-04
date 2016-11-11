package ar.fiuba.tdd.grupo04.model.rule;

import ar.fiuba.tdd.grupo04.model.inputs.IInput;

import java.util.List;

public class InputGroup implements IInputGroup {

    private final List<IInput> inputs;

    public InputGroup(List<IInput> inputs) {
        this.inputs = inputs;
    }

    public List<IInput> getInputs() {
        return inputs;
    }
}
