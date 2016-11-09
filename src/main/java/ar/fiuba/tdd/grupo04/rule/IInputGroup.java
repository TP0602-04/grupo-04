package ar.fiuba.tdd.grupo04.rule;

import ar.fiuba.tdd.grupo04.inputs.IInput;

import java.util.List;

public interface IInputGroup<R extends IInput> {
    List<R> getInputs();
}
