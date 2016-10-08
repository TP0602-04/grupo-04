package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

public class SumCondition<R extends IValuedInputGroup<Integer, Integer>> implements ICondition<R> {
    public boolean check(R inputGroup) {
        return inputGroup.getValue().equals(inputGroup.getInputs().stream().mapToInt(Integer::intValue).sum());
    }
}
