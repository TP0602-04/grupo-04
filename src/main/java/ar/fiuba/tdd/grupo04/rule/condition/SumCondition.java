package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

import java.util.Optional;
import java.util.stream.Stream;

public class SumCondition<R extends IValuedInputGroup<Integer, Integer>> implements ICondition<R> {

    /**
     * Returns false if all the inputs of the group are present and
     * dont sum the group value, true otherwise
     * @param inputGroup the input group to check
     * @return if the group sums the value or is incomplete
     */
    public boolean check(R inputGroup) {
        final Integer value = inputGroup.getValue();
        final Stream<Optional<Integer>> inputsStream = inputGroup.getInputs().stream();
        if (inputsStream.allMatch(Optional::isPresent)) {
            return value.equals(inputsStream.map(Optional::get).mapToInt(Integer::intValue).sum());
        }
        return true;
    }
}
