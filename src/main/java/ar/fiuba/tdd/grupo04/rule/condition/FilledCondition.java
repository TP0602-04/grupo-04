package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.List;
import java.util.stream.Collectors;

public class FilledCondition implements ICondition {
    @Override
    public boolean check(CellGroup cellGroup) {
        List<Cell> emptyCells = cellGroup
                .getCells()
                .stream()
                .filter(cell -> cell.getValue() == null)
                .collect(Collectors.toList());
        boolean check = emptyCells.isEmpty();
        if (!check) {
            String message = emptyCells
                    .stream()
                    .map(cell -> cell.getCoordinate().toString())
                    .reduce("Empy cells: ", (s1, s2) -> s1 + " " + s2);
            printError(message);
        }
        return check;
    }

    private void printError(String message) {
        message = "============= FAILED =============\n" +
                "Condition: FilledCondition\n" +
                message;
        System.out.println(message);
    }
}
