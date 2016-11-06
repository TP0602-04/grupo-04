package ar.fiuba.tdd.pgotuzzo.rule;

import ar.fiuba.tdd.pgotuzzo.IBoard;
import ar.fiuba.tdd.pgotuzzo.rule.collector.ICollector;
import ar.fiuba.tdd.pgotuzzo.rule.condition.ICondition;

import java.util.stream.Stream;

public abstract class Rule<T> implements IRule {

    abstract protected ICondition<T> getCondition();

    abstract protected ICollector<T> getCollector();

    @Override
    public boolean check(IBoard board) {
        Stream<T> collections = getCollector().collect(board).stream();
        return collections
                .map(cellGroup -> getCondition().check(cellGroup))
                .reduce((res1, res2) -> res1 && res2)
                .get();
    }
}
