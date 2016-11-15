package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.inputs.BooleanInput;
import ar.fiuba.tdd.grupo04.model.inputs.GraphInput;
import ar.fiuba.tdd.grupo04.model.inputs.GraphInputType;
import ar.fiuba.tdd.grupo04.model.inputs.IInput;
import ar.fiuba.tdd.grupo04.model.rule.IValuedInputGroup;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.lang.Integer.toUnsignedLong;

@SuppressWarnings("CPD-START")
public class CountBooleanCondition<R extends IValuedInputGroup<BooleanInput, Integer>> implements ICondition<R> {
    private final BiFunction<Long, Long, Boolean> comparator;

    public CountBooleanCondition(BiFunction<Long, Long, Boolean> comparator) {
        this.comparator = comparator;
    }

    @Override
    public boolean check(R valuedInputGroup) {
        final Stream<BooleanInput> stream = valuedInputGroup.getInputs().stream();
        final long countedInputs = stream.filter(IInput::isFilled).filter(BooleanInput::getState).count();
        return comparator.apply(toUnsignedLong(valuedInputGroup.getValue()), countedInputs);
    }
}
