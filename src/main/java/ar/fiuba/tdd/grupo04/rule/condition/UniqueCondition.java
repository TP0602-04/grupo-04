package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;

import java.util.List;
import java.util.Optional;

public class UniqueCondition implements ICondition {

    @Override
    public boolean check(IInputGroup inputGroup) {
        final List<IInput> inputs = inputGroup.getInputs();
        final long diffCount = inputs.stream().map(IInput::getValue).filter(Optional::isPresent).map(Optional::get).distinct().count();
        final long count = inputs.stream().map(IInput::getValue).filter(Optional::isPresent).map(Optional::get).count();
        return diffCount == count;
    }
}
