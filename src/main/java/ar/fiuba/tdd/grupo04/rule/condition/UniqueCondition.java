package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.rule.IInputGroup;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class UniqueCondition implements ICondition {
    @Override
    public boolean check(IInputGroup inputGroup) {
        final List<Optional> inputs = inputGroup.getInputs();
        final Stream inputsStream = inputs.stream().filter(Optional::isPresent).map(Optional::get);
        return inputsStream.distinct().count() == inputsStream.count();
    }
}
