package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

import java.util.Optional;

public class SumCondition<R extends IValuedInputGroup<Integer, Integer>> implements ICondition<R> {

    /*
     * Returns false if all the inputs of the group are present and
     * don't sum the group value, true otherwise
     * @param valuedInputGroup the input group to check
     * @return if the group sums the value or is incomplete
     */
    public boolean check(R valuedInputGroup) {
        final Integer value = valuedInputGroup.getValue();
        final boolean allMatch = valuedInputGroup.getInputs().stream().map(IInput::getValue).allMatch(Optional::isPresent);
        if (allMatch) {
            return value.equals(valuedInputGroup.getInputs().stream().map(IInput::getValue).map(Optional::get).mapToInt(Integer::intValue).sum());
        }
        return true;
    }
}
