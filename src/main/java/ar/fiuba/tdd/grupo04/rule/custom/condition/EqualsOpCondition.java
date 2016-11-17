package ar.fiuba.tdd.grupo04.rule.custom.condition;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.rule.condition.Condition;
import ar.fiuba.tdd.grupo04.rule.custom.ReferencedCellGroup;

public abstract class EqualsOpCondition extends Condition implements ICustomCondition {
    public enum Operation {
        SUM,
        MULTIPLY
    }

    private Operation operation;
    private Integer initialValue;

    public EqualsOpCondition(Operation operation, Integer initialValue) {
        this.operation = operation;
        this.initialValue = initialValue;
    }

    @Override
    public boolean check(ReferencedCellGroup referencedCellGroup) {
        Integer expected = referencedCellGroup.getReferencedValues().get(0);
        Integer real = referencedCellGroup
                .getFilledCells()
                .stream()
                .map(Cell::getValue)
                .reduce(initialValue, this::apply);
        return expected.equals(real);
    }

    private Integer apply(Integer value1, Integer value2) {
        switch (operation) {
            case SUM:
                return value1 + value2;
            case MULTIPLY:
                return value1 * value2;
            default:
                return null;
        }
    }

}
