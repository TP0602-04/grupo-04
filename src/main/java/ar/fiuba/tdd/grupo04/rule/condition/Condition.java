package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Cell;

import java.util.List;

public abstract class Condition {
    abstract protected String getConditionName();

    protected void printError(List<Cell> cells) {
        String message = cells.stream()
                .map(cell -> cell.getCoordinate().toString())
                .reduce("Cells in conflict: ", (s1, s2) -> s1 + " " + s2);
        printError(message);
    }

    protected void printError(String message) {
        message = "============= FAILED =============\n"
                + "Condition: " + getConditionName() + "\n"
                + message;
        System.out.println(message);
    }

}
