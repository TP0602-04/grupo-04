package ar.fiuba.tdd.pgotuzzo.rule.condition;

import ar.fiuba.tdd.pgotuzzo.board.Cell;
import ar.fiuba.tdd.pgotuzzo.rule.ReferencedCellGroup;

public class EqualsSumCondition implements ICondition<ReferencedCellGroup> {
    @Override
    public boolean check(ReferencedCellGroup referencedCellGroup) {
        Integer expected = referencedCellGroup.getRefrencedValue();
        Integer real = referencedCellGroup
                .getFilledCells()
                .stream()
                .map(Cell::getValue)
                .reduce(0, (v1, v2) -> v1 + v2);
        return expected.equals(real);
    }
}
