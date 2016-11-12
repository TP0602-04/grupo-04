package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.inputs.NumericInput;
import ar.fiuba.tdd.grupo04.model.rule.IValuedInputGroup;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class AllComparatorCondition<R extends IValuedInputGroup<NumericInput, Integer>> implements ICondition<R> {
    private final BiFunction<Integer, Integer, Boolean> comparator;

    public AllComparatorCondition(BiFunction<Integer, Integer, Boolean> comparator) {
        this.comparator = comparator;
    }

    public boolean check(R valuedInputGroup) {
        final Integer value = valuedInputGroup.getValue();
        final Stream<Optional<Integer>> inputsStream = valuedInputGroup.getInputs().stream().map(NumericInput::getValue);
        return inputsStream.filter(Optional::isPresent).map(Optional::get).allMatch(i -> comparator.apply(i, value));
    }
}