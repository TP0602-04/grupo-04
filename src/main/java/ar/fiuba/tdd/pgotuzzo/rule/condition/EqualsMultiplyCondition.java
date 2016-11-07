package ar.fiuba.tdd.pgotuzzo.rule.condition;

import ar.fiuba.tdd.pgotuzzo.board.Cell;
import ar.fiuba.tdd.pgotuzzo.rule.ReferencedCellGroup;

public class EqualsMultiplyCondition implements ICondition<ReferencedCellGroup> {
    @Override
    public boolean check(ReferencedCellGroup referencedCellGroup) {
        Integer expected = referencedCellGroup.getReferencedValues().get(0);
        Integer real = referencedCellGroup
                .getFilledCells()
                .stream()
                .map(Cell::getValue)
                .reduce(1, (v1, v2) -> v1 * v2);
        return expected.equals(real);
    }
}