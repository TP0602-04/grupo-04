package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.List;
import java.util.stream.Collectors;

public class LesserThanSlotSize implements ICondition {

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
            String message = greaterCells
                    .stream()
                    .map(cell -> cell.getCoordinate().toString())
                    .reduce("Greater cells: ", (s1, s2) -> s1 + " " + s2);
            printError(message);
        }
        return check;
    }

    private void printError(String message) {
        message = "============= FAILED =============\n"
                + "Condition: LesserThanSlotSize\n" 
                + message;
        System.out.println(message);
    }

}
