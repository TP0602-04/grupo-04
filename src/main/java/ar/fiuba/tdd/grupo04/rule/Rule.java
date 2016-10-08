package ar.fiuba.tdd.grupo04.rule;

import ar.fiuba.tdd.grupo04.rule.collector.ICollector;
import ar.fiuba.tdd.grupo04.rule.condition.ICondition;

public class Rule<R extends IInputGroup> implements IRule {
    private final ICondition<R> condition;
    private final ICollector<R> collector;

    public Rule(ICollector<R> collector, ICondition<R> condition) {
        this.collector = collector;
        this.condition = condition;
    }

    @Override
    public boolean check() {
        return collector.getInputGroups().stream().allMatch(condition::check);
    }
}
