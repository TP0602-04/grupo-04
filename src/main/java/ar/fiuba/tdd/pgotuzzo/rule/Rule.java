package ar.fiuba.tdd.pgotuzzo.rule;

import ar.fiuba.tdd.pgotuzzo.IBoard;
import ar.fiuba.tdd.pgotuzzo.rule.collector.ICollector;
import ar.fiuba.tdd.pgotuzzo.rule.condition.ICondition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Rule<T> implements IRule {
    private ICollector<T> collector;
    private List<ICondition<T>> conditions;

    public Rule(ICollector<T> collector, List<ICondition<T>> conditions) {
        this.collector = collector;
        this.conditions = new ArrayList<>();
        this.conditions.addAll(conditions);
    }

    @Override
    public boolean check(IBoard board) {
        Stream<T> collections = collector.collect(board).stream();
        return collections
                .map(this::check)
                .reduce(true, (res1, res2) -> res1 && res2);
    }

    public boolean check(T predicate) {
        return conditions
                .stream()
                .map(condition -> condition.check(predicate))
                .reduce(true, (b1, b2) -> b1 && b2);
    }

}
