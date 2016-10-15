package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.rule.IInputGroup;

import java.util.List;
import java.util.Optional;

public class AllFilledCondition implements ICondition {
    @Override
    public boolean check(IInputGroup inputGroup) {
        final List<Optional> inputs = inputGroup.getInputs();
        return inputs.stream().allMatch(Optional::isPresent);
    }
}
