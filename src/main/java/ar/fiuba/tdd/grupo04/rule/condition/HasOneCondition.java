package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public class HasOneCondition<R extends IInputGroup<Boolean>> implements ICondition<R> {
    private final BiFunction<Coordinate, Boolean, Boolean> comparator;

    public HasOneCondition(BiFunction<Coordinate, Boolean, Boolean> comparator) {
        this.comparator = comparator;
    }

    @Override
    public boolean check(R valuedInputGroup) {
        final Stream<IInput<Boolean>> inputsStream = valuedInputGroup.getInputs().stream();
        return inputsStream.filter(i -> i.getValue().isPresent()).allMatch(i -> comparator.apply(i.getCoordinate(), i.getValue().get()));
    }
}
