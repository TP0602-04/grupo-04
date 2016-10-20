package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class CountCondition<R extends IValuedInputGroup<?, Integer>> implements ICondition<R> {
    private final Function<Coordinate, Boolean> isCountable;

    public CountCondition(Function<Coordinate, Boolean> isCountable) {
        this.isCountable = isCountable;
    }

    @Override
    public boolean check(R valuedInputGroup) {
        final Stream<? extends IInput<?>> stream = valuedInputGroup.getInputs().stream();
        final long countedInputs = stream.filter(i -> i.getValue().isPresent()).filter(i -> isCountable.apply(i.getCoordinate())).count();
        return valuedInputGroup.getValue() == countedInputs;
    }
}
