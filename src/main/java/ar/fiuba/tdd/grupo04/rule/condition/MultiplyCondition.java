package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

import java.util.Optional;

@SuppressWarnings("CPD-START")
public class MultiplyCondition<R extends IValuedInputGroup<Integer, Integer>> implements ICondition<R> {

    public boolean check(R valuedInputGroup) {
        final Integer value = valuedInputGroup.getValue();
        final boolean allMatch = valuedInputGroup.getInputs().stream().map(IInput::getValue).allMatch(Optional::isPresent);
        if (allMatch) {
            //TODO: Arreglar esa negrada de aaA y bbB con nombres reales
            return value.equals(valuedInputGroup.getInputs().stream().map(IInput::getValue)
                                        .map(Optional::get).reduce(1, (foo, bar) -> foo * bar));
        }
        return true;
    }
}
