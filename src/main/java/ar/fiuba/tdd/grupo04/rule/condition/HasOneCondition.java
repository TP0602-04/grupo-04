package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;

import java.util.function.Function;
import java.util.stream.Stream;

public class HasOneCondition<S, R extends IInputGroup<S>> implements ICondition<R> {
    private final Function<S, Boolean> condition;

    public HasOneCondition(Function<S, Boolean> condition) {
        this.condition = condition;
    }

    @Override
    public boolean check(R inputGroup) {
        final Stream<IInput<S>> inputsStream = inputGroup.getInputs().stream();
        return inputsStream.filter(i -> i.getValue().isPresent()).anyMatch(i -> condition.apply(i.getValue().get()));
    }
}
