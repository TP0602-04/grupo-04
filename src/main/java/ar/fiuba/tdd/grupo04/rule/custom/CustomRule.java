package ar.fiuba.tdd.grupo04.rule.custom;

import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.rule.IRule;
import ar.fiuba.tdd.grupo04.rule.condition.ICondition;
import ar.fiuba.tdd.grupo04.rule.custom.collector.ICustomCollector;
import ar.fiuba.tdd.grupo04.rule.custom.condition.ICustomCondition;

import java.util.ArrayList;
import java.util.List;

public class CustomRule implements IRule {
    private ICustomCollector collector;
    private List<ICustomCondition> customConditions;
    private List<ICondition> conditions;

    public CustomRule(ICustomCollector collector, List<ICondition> conditions, List<ICustomCondition> customConditions) {
        this.collector = collector;
        this.conditions = new ArrayList<>();
        this.conditions.addAll(conditions);
        this.customConditions = new ArrayList<>();
        this.customConditions.addAll(customConditions);
    }

    @Override
    public boolean check(IBoard board) {
        return collector.collect(board).stream()
                .map(this::check)
                .reduce(true, (res1, res2) -> res1 && res2);
    }

    public boolean check(ReferencedCellGroup referencedCellGroup) {
        boolean firstCheck = conditions.stream()
                .map(condition -> condition.check(referencedCellGroup))
                .reduce(true, (b1, b2) -> b1 && b2);
        boolean secondCheck = customConditions.stream()
                .map(condition -> condition.check(referencedCellGroup))
                .reduce(true, (b1, b2) -> b1 && b2);
        return firstCheck && secondCheck;
    }
}
