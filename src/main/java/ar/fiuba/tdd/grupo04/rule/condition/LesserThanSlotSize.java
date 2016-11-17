package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.List;
import java.util.stream.Collectors;

public class LesserThanSlotSize extends Condition implements ICondition {

    @Override
    protected String getConditionName() {
        return LesserThanSlotSize.class.getSimpleName();
    }

    @Override
    public boolean check(CellGroup cellGroup) {
        int slotSize = cellGroup.getCells().size();
        List<Cell> filledCells = cellGroup.getFilledCells();
        List<Cell> greaterCells = filledCells
                .stream()
                .filter(cell -> cell.getValue() > slotSize)
                .collect(Collectors.toList());
        boolean check = greaterCells.isEmpty();
        if (!check) {
            printError(greaterCells);
        }
        return check;
    }

}
