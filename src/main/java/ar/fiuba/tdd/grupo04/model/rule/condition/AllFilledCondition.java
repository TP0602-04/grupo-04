package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.inputs.IInput;
import ar.fiuba.tdd.grupo04.model.rule.IInputGroup;

import java.util.List;

public class AllFilledCondition<R extends IInputGroup<IInput>> implements ICondition<R> {
    @Override
    public boolean check(R inputGroup) {
        final List<IInput> inputs = inputGroup.getInputs();
        return inputs.stream().allMatch(IInput::isFilled);
    }
}