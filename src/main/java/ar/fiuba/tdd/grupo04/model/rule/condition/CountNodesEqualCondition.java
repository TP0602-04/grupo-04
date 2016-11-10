package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.inputs.GraphInput;
import ar.fiuba.tdd.grupo04.model.inputs.GraphInputType;
import ar.fiuba.tdd.grupo04.model.rule.IValuedInputGroup;

@SuppressWarnings("CPD-START")
public class CountNodesEqualCondition<R extends IValuedInputGroup<GraphInput, Integer>> implements ICondition<R> {
    private final CountGraphCondition<R> countGraphCondition;

    public CountNodesEqualCondition() {
        this.countGraphCondition = new CountGraphCondition<>(GraphInputType.NODE, (expected, counted) -> expected == counted);
    }

    @Override
    public boolean check(R valuedInputGroup) {
        return countGraphCondition.check(valuedInputGroup);
    }
}
