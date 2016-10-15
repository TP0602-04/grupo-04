package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

import java.util.Optional;
import java.util.stream.Stream;

public class SumCondition<R extends IValuedInputGroup<Integer, Integer>> implements ICondition<R> {

    /*
     * Returns false if all the inputs of the group are present and
     * don't sum the group value, true otherwise
     * @param valuedInputGroup the input group to check
     * @return if the group sums the value or is incomplete
     */
    public boolean check(R valuedInputGroup) {
        final Integer value = valuedInputGroup.getValue();
        final Stream<Optional<Integer>> inputsStream = valuedInputGroup.getInputs().stream().map(IInput::getValue);
        if (inputsStream.allMatch(Optional::isPresent)) {
            return value.equals(inputsStream.map(Optional::get).mapToInt(Integer::intValue).sum());
        }
        return true;
    }
}
