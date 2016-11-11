package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.inputs.NumericInput;
import ar.fiuba.tdd.grupo04.model.rule.IValuedInputGroup;

@SuppressWarnings("CPD-START")
public class MultiplyCondition<R extends IValuedInputGroup<NumericInput, Integer>> implements ICondition<R> {
    private final OperationCondition<IValuedInputGroup<NumericInput, Integer>> multiplyOperation;

    public MultiplyCondition() {
        multiplyOperation = new OperationCondition<>(1, (mem, val) -> mem * val);
    }

    @Override
    public boolean check(R valuedInputGroup) {
        return multiplyOperation.check(valuedInputGroup);
    }
}
