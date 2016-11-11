package ar.fiuba.tdd.grupo04.model.rule;

import ar.fiuba.tdd.grupo04.model.rule.collector.ICollector;
import ar.fiuba.tdd.grupo04.model.rule.condition.ICondition;

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
