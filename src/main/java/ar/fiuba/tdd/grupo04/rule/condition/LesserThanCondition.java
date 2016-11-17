package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.rule.CellGroup;

public class LesserThanCondition implements ICondition {
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
