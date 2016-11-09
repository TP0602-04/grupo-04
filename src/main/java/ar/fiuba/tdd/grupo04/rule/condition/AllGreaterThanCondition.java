package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.inputs.NumericInput;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

public class AllGreaterThanCondition<R extends IValuedInputGroup<NumericInput, Integer>> implements ICondition<R> {
    private final AllComparatorCondition<R> allComparatorCondition = new AllComparatorCondition<>((foo, bar) -> foo > bar);

    public boolean check(R valuedInputGroup) {
        return allComparatorCondition.check(valuedInputGroup);
    }
}
