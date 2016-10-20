package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class CountCondition<S, R extends IValuedInputGroup<S, Integer>> implements ICondition<R> {
    private final Function<S, Boolean> isCountable;
    private final BiFunction<Integer, Integer, Boolean> comparator;

    public CountCondition(Function<S, Boolean> isCountable, BiFunction<Integer, Integer, Boolean> comparator) {
        this.isCountable = isCountable;
        this.comparator = comparator;
    }

    @Override
    public boolean check(R valuedInputGroup) {
        final Stream<? extends IInput<S>> stream = valuedInputGroup.getInputs().stream();
        final long countedInputs = stream.filter(i -> i.getValue().isPresent()).filter(i -> isCountable.apply(i.getValue().get())).count();
        return comparator.apply(valuedInputGroup.getValue(), (int) countedInputs);
    }
}
