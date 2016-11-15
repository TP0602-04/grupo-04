package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.inputs.GraphInput;
import ar.fiuba.tdd.grupo04.model.inputs.GraphInputType;
import ar.fiuba.tdd.grupo04.model.inputs.IInput;
import ar.fiuba.tdd.grupo04.model.rule.IValuedInputGroup;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.lang.Integer.toUnsignedLong;

@SuppressWarnings("CPD-START")
public class CountGraphCondition<R extends IValuedInputGroup<GraphInput, Integer>> implements ICondition<R> {
    private final GraphInputType graphInputType;
    private final BiFunction<Long, Long, Boolean> comparator;

    public CountGraphCondition(GraphInputType graphInputType, BiFunction<Long, Long, Boolean> comparator) {
        this.graphInputType = graphInputType;
        this.comparator = comparator;

    }

    @Override
    public boolean check(R valuedInputGroup) {
        if (valuedInputGroup.getValue() == -1) {
            return true;
        }
        final Stream<GraphInput> stream = valuedInputGroup.getInputs().stream();
        final long countedInputs = stream.filter(IInput::isFilled).filter(GraphInput::isMarked).filter(i -> i.getType().equals(graphInputType)).count();
        return comparator.apply(toUnsignedLong(valuedInputGroup.getValue()), countedInputs);
    }
}
