package ar.fiuba.tdd.grupo04.rule;

import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.rule.collector.ICollector;
import ar.fiuba.tdd.grupo04.rule.condition.ICondition;

import java.util.ArrayList;
import java.util.List;

public class Rule implements IRule {
    private ICollector collector;
    private List<ICondition> conditions;

    public Rule(ICollector collector, List<ICondition> conditions) {
        this.collector = collector;
        this.conditions = new ArrayList<>();
        this.conditions.addAll(conditions);
    }

    @Override
    public boolean check(IBoard board) {
        return collector.collect(board).stream()
                .map(this::check)
                .reduce(true, (res1, res2) -> res1 && res2);
    }

    public boolean check(CellGroup cellGroup) {
        return conditions
                .stream()
                .map(condition -> condition.check(cellGroup))
                .reduce(true, (b1, b2) -> b1 && b2);
    }

}
