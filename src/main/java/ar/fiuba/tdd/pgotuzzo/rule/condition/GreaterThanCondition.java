package ar.fiuba.tdd.pgotuzzo.rule.condition;

import ar.fiuba.tdd.pgotuzzo.rule.CellGroup;

public class GreaterThanCondition implements ICondition<CellGroup> {

    private int min;

    public GreaterThanCondition(int min) {
        this.min = min;
    }

    @Override
    public boolean check(CellGroup cellGroup) {
        return cellGroup
                .getFilledCells()
                .stream()
                .map(cell -> cell.getValue() > min)
                .reduce(true, (b1, b2) -> b1 && b2);
    }

}