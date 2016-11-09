package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.inputs.GraphInput;
import ar.fiuba.tdd.grupo04.inputs.GraphInputType;
import ar.fiuba.tdd.grupo04.inputs.IInput;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.Integer.toUnsignedLong;

public class CountGraphCondition<R extends IValuedInputGroup<GraphInput, Integer>> implements ICondition<R> {
    private final GraphInputType graphInputType;
    private final BiFunction<Long, Long, Boolean> comparator;

    public CountGraphCondition(GraphInputType graphInputType, BiFunction<Long, Long, Boolean> comparator) {
        this.graphInputType = graphInputType;
        this.comparator = comparator;

    }

    @Override
    public boolean check(R valuedInputGroup) {
        final Stream<GraphInput> stream = valuedInputGroup.getInputs().stream();
        final long countedInputs = stream.filter(IInput::isFilled).filter(i -> i.getType().equals(graphInputType)).count();
        return comparator.apply(toUnsignedLong(valuedInputGroup.getValue()), countedInputs);
    }
}
