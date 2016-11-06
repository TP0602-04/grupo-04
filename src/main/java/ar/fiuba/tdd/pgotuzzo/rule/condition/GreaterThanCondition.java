package ar.fiuba.tdd.pgotuzzo.rule.condition;

import ar.fiuba.tdd.pgotuzzo.rule.CellGroup;

public class GreaterThanCondition implements ICondition<CellGroup> {

    private int max;

    public GreaterThanCondition(int max) {
        this.max = max;
    }

    @Override
    public boolean check(CellGroup cellGroup) {
        return cellGroup.getCells().stream()
                .map(cell -> cell.getValue() < max)
                .reduce((b1, b2) -> b1 && b2)
                .get();
    }

}
