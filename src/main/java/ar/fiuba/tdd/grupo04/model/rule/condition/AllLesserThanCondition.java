package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.inputs.NumericInput;
import ar.fiuba.tdd.grupo04.model.rule.IValuedInputGroup;

public class AllLesserThanCondition<R extends IValuedInputGroup<NumericInput, Integer>> implements ICondition<R> {
    private final AllComparatorCondition<R> allComparatorCondition = new AllComparatorCondition<>((foo, bar) -> foo < bar);

    public boolean check(R valuedInputGroup) {
        return allComparatorCondition.check(valuedInputGroup);
    }
}
