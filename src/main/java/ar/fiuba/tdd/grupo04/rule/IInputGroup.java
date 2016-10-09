package ar.fiuba.tdd.grupo04.rule;

import java.util.List;
import java.util.Optional;

public interface IInputGroup<T> {
    List<Optional<T>> getInputs();
}
