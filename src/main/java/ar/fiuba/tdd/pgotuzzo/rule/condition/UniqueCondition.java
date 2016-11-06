package ar.fiuba.tdd.pgotuzzo.rule.condition;

import ar.fiuba.tdd.pgotuzzo.rule.CellGroup;

public class UniqueCondition implements ICondition<CellGroup> {
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
