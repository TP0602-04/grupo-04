package ar.fiuba.tdd.pgotuzzo.rule.condition;

import ar.fiuba.tdd.pgotuzzo.rule.CellGroup;

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
