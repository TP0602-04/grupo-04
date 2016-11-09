package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.inputs.IInput;
import ar.fiuba.tdd.grupo04.inputs.NumericInput;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

import java.util.Optional;

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
