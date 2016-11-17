package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.rule.CellGroup;

public class UniqueCondition extends Condition implements ICondition {

    @Override
    protected String getConditionName() {
        return UniqueCondition.class.getSimpleName();
    }

    @Override
    public boolean check(CellGroup cellGroup) {
        return cellGroup
                .getFilledCells()
                .stream()
                .map(cell -> checkRepeated(cellGroup, cell.getValue()))
                .reduce(true, (b1, b2) -> b1 && b2);
    }

    private boolean checkRepeated(CellGroup cellGroup, int value) {
        long count = cellGroup
                .getFilledCells()
                .stream()
                .filter(cell -> cell.getValue() == value).count();
        return count == 1;
    }

}
