package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

public abstract class CompareCondition extends Condition implements ICondition {
    public enum Comparator {
        LESSER,
        GREATER
    }

    private int value;
    private Comparator comparator;

    public CompareCondition(Comparator comparator, int value) {
        this.comparator = comparator;
        this.value = value;
    }

    @Override
    public boolean check(CellGroup cellGroup) {
        return cellGroup
                .getFilledCells()
                .stream()
                .map(this::compare)
                .reduce(true, (b1, b2) -> b1 && b2);
    }

    private boolean compare(Cell cell) {
        switch (comparator) {
            case LESSER:
                return cell.getValue() < value;
            case GREATER:
                return cell.getValue() > value;
            default:
                return false;
        }
    }
}
