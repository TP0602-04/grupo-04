package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;

import java.util.List;
import java.util.Optional;

public class AllFilledCondition implements ICondition {
    @Override
    public boolean check(IInputGroup inputGroup) {
        final List<IInput> inputs = inputGroup.getInputs();
        return inputs.stream().map(IInput::getValue).allMatch(Optional::isPresent);
    }
}
