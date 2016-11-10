package ar.fiuba.tdd.grupo04.model.rule;

import ar.fiuba.tdd.grupo04.model.inputs.IInput;

public interface IValuedInputGroup<R extends IInput, S> extends IInputGroup<R> {
    S getValue();
}
