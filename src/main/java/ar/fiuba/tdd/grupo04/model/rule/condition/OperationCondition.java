package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.inputs.IInput;
import ar.fiuba.tdd.grupo04.model.inputs.NumericInput;
import ar.fiuba.tdd.grupo04.model.rule.IValuedInputGroup;

import java.util.Optional;
import java.util.function.BinaryOperator;

public class OperationCondition<R extends IValuedInputGroup<NumericInput, Integer>> implements ICondition<R> {
    private final Integer initialState;
    private final BinaryOperator<Integer> accumulator;

    public OperationCondition(Integer initialState, BinaryOperator<Integer> accumulator) {
        this.initialState = initialState;
        this.accumulator = accumulator;
    }

    /*
         * Returns false if all the inputs of the group are present and
         * don't sum the group value, true otherwise
         * @param valuedInputGroup the input group to check
         * @return if the group sums the value or is incomplete
         */
    @Override
    public boolean check(R valuedInputGroup) {
        final Integer value = valuedInputGroup.getValue();
        return value.equals(valuedInputGroup.getInputs().stream().filter(IInput::isFilled).map(NumericInput::getValue)
                    .map(Optional::get).reduce(initialState, accumulator));
    }
}
