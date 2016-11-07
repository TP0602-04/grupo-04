package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.rule.CellGroup;

public class FilledCondition implements ICondition<CellGroup> {
    @Override
    public boolean check(CellGroup cellGroup) {
        return cellGroup
                .getCells()
                .stream()
                .map(cell -> cell.getValue() != null)
                .reduce(true, (b1, b2) -> b1 && b2);
    }
}
