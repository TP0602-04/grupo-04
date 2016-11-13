package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.inputs.BooleanInput;
import ar.fiuba.tdd.grupo04.model.rule.IInputGroup;

@SuppressWarnings("CPD-START")
public class MoreThanTwoContiguousMarkedCondition<R extends IInputGroup<BooleanInput>> implements ICondition<R> {
    private final TwoContiguousMarkedComparatorCondition<R> comparatorCondition;

    public MoreThanTwoContiguousMarkedCondition() {
        this.comparatorCondition = new TwoContiguousMarkedComparatorCondition<>((expected, counted) -> expected >= counted);
    }

    @Override
    public boolean check(R valuedInputGroup) {
        return comparatorCondition.check(valuedInputGroup);
    }
}