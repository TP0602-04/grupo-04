package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.rule.IInputGroup;

import java.util.stream.Stream;

public class UniqueCondition implements ICondition {
    @Override
    public boolean check(IInputGroup inputGroup) {
        final Stream inputsStream = inputGroup.getInputs().stream();
        return inputsStream.distinct().count() == inputsStream.count();
    }
}
