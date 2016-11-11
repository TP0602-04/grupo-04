package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.inputs.NumericInput;
import ar.fiuba.tdd.grupo04.model.rule.IValuedInputGroup;

public class SumCondition<R extends IValuedInputGroup<NumericInput, Integer>> implements ICondition<R> {
    private final OperationCondition<IValuedInputGroup<NumericInput, Integer>> sumOperation;

    public SumCondition() {
        sumOperation = new OperationCondition<>(0, Integer::sum);
    }

    @Override
    public boolean check(R valuedInputGroup) {
        return sumOperation.check(valuedInputGroup);
    }
}
