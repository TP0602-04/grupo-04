package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.inputs.NumericInput;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;

import java.util.List;
import java.util.Optional;

public class UniqueCondition<R extends IInputGroup<NumericInput>> implements ICondition<R> {

    @Override
    public boolean check(R inputGroup) {
        final List<NumericInput> inputs = inputGroup.getInputs();
        final long diffCount = inputs.stream().filter(NumericInput::isFilled).map(NumericInput::getValue).map(Optional::get).distinct().count();
        final long count = inputs.stream().filter(NumericInput::isFilled).map(NumericInput::getValue).map(Optional::get).count();
        return diffCount == count;
    }
}
