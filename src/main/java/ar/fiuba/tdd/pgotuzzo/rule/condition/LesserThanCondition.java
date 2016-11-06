package ar.fiuba.tdd.pgotuzzo.rule.condition;

import ar.fiuba.tdd.pgotuzzo.rule.CellGroup;

public class LesserThanCondition implements ICondition<CellGroup> {
    private int max;

    public LesserThanCondition(int min) {
        this.max = min;
    }

    @Override
    public boolean check(CellGroup cellGroup) {
        return cellGroup
                .getFilledCells()
                .stream()
                .map(cell -> cell.getValue() < max)
                .reduce(true, (b1, b2) -> b1 && b2);
    }

}
