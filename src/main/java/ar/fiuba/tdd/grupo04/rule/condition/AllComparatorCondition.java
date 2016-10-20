package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class AllComparatorCondition<R extends IValuedInputGroup<Integer, Integer>> implements ICondition<R> {
    private final BiFunction<Integer, Integer, Boolean> comparator;

    public AllComparatorCondition(BiFunction<Integer, Integer, Boolean> comparator) {
        this.comparator = comparator;
    }

    public boolean check(R valuedInputGroup) {
        final Integer value = valuedInputGroup.getValue();
        final Stream<Optional<Integer>> inputsStream = valuedInputGroup.getInputs().stream().map(IInput::getValue);
        return inputsStream.filter(Optional::isPresent).map(Optional::get).allMatch(i -> comparator.apply(i, value));
    }
}
