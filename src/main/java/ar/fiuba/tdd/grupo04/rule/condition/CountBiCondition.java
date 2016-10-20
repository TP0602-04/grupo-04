package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.games.ValuedCoordinate;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

@SuppressWarnings("CPD-START")
public class CountBiCondition<R extends IValuedInputGroup<?, ValuedCoordinate<Integer>>> implements ICondition<R> {
    private final BiFunction<ValuedCoordinate, Coordinate, Boolean> countableValue;

    public CountBiCondition(BiFunction<ValuedCoordinate, Coordinate, Boolean> countableValue) {
        this.countableValue = countableValue;
    }

    @Override
    public boolean check(R valuedInputGroup) {
        final Stream<? extends IInput<?>> stream = valuedInputGroup.getInputs().stream();
        final ValuedCoordinate<Integer> valuedCoordinate = valuedInputGroup.getValue();
        final long countedInputs = stream.filter(i -> i.getValue().isPresent()).filter(i -> i.getValue().get().equals(countableValue.apply(valuedCoordinate, i.getCoordinate()))).count();
        return valuedCoordinate.getValue() == countedInputs;
    }
}
