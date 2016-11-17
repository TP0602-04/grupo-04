package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.List;
import java.util.stream.Collectors;

public class FilledCondition extends Condition implements ICondition {

    @Override
    protected String getConditionName() {
        return FilledCondition.class.getSimpleName();
    }

    @Override
    public boolean check(CellGroup cellGroup) {
        List<Cell> emptyCells = cellGroup
                .getCells()
                .stream()
                .filter(cell -> cell.getValue() == null)
                .collect(Collectors.toList());
        boolean check = emptyCells.isEmpty();
        if (!check) {
            printError(emptyCells);
        }
        return check;
    }

}
