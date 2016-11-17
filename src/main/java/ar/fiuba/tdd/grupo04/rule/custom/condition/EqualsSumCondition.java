package ar.fiuba.tdd.grupo04.rule.custom.condition;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.rule.custom.ReferencedCellGroup;

public class EqualsSumCondition implements ICustomCondition {
    @Override
    public boolean check(ReferencedCellGroup referencedCellGroup) {
        Integer expected = referencedCellGroup.getReferencedValues().get(0);
        Integer real = referencedCellGroup
                .getFilledCells()
                .stream()
                .map(Cell::getValue)
                .reduce(0, (v1, v2) -> v1 + v2);
        return expected.equals(real);
    }
}
