package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

public class AllLesserThanCondition<R extends IValuedInputGroup<Integer, Integer>> implements ICondition<R> {
    private final AllComparatorCondition<R> allComparatorCondition = new AllComparatorCondition<R>((foo, bar) -> foo < bar);

    public boolean check(R valuedInputGroup) {
        return allComparatorCondition.check(valuedInputGroup);
    }
}
