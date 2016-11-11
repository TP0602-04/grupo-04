package ar.fiuba.tdd.grupo04.model.rule;

import ar.fiuba.tdd.grupo04.model.inputs.IInput;

import java.util.List;

public interface IInputGroup<R extends IInput> {
    List<R> getInputs();
}
