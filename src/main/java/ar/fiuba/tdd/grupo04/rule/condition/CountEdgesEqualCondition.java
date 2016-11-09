package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.inputs.GraphInput;
import ar.fiuba.tdd.grupo04.inputs.GraphInputType;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

@SuppressWarnings("CPD-START")
public class CountEdgesEqualCondition<R extends IValuedInputGroup<GraphInput, Integer>> implements ICondition<R> {
    private final CountGraphCondition<R> countGraphCondition;

    public CountEdgesEqualCondition() {
        this.countGraphCondition = new CountGraphCondition<>(GraphInputType.EDGE, (expected, counted) -> expected == counted);
    }

    @Override
    public boolean check(R valuedInputGroup) {
        return countGraphCondition.check(valuedInputGroup);
    }
}
