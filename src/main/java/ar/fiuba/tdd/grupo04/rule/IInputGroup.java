package ar.fiuba.tdd.grupo04.rule;

import ar.fiuba.tdd.grupo04.board.IInput;

import java.util.List;

public interface IInputGroup<T> {
    List<IInput<T>> getInputs();
}
