package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.inputs.GraphInput;
import ar.fiuba.tdd.grupo04.inputs.IInput;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;

import java.util.List;
import java.util.Optional;

public class AllFilledCondition<R extends IInputGroup<IInput>> implements ICondition<R> {
    @Override
    public boolean check(R inputGroup) {
        final List<IInput> inputs = inputGroup.getInputs();
        return inputs.stream().allMatch(IInput::isFilled);
    }
}
