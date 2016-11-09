package ar.fiuba.tdd.grupo04.rule;

import ar.fiuba.tdd.grupo04.inputs.IInput;

public interface IValuedInputGroup<R extends IInput, S> extends IInputGroup<R> {
    S getValue();
}
