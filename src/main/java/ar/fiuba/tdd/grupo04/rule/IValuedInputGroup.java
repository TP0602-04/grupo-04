package ar.fiuba.tdd.grupo04.rule;

public interface IValuedInputGroup<T, S> extends IInputGroup<T> {
    S getValue();
}
