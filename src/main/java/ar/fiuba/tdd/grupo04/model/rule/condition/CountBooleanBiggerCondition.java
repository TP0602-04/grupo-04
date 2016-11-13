package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.inputs.BooleanInput;
import ar.fiuba.tdd.grupo04.model.rule.IValuedInputGroup;

@SuppressWarnings("CPD-START")
public class CountBooleanBiggerCondition<R extends IValuedInputGroup<BooleanInput, Integer>> implements ICondition<R> {
    private final CountBooleanCondition<R> countBooleanCondition;

    public CountBooleanBiggerCondition() {
        this.countBooleanCondition = new CountBooleanCondition<>((expected, counted) -> expected >= counted);
    }

    @Override
    public boolean check(R valuedInputGroup) {
        return countBooleanCondition.check(valuedInputGroup);
    }
}
