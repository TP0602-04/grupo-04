package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.neighborhood.Neighborhood;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.List;

public class NoLoopCondition extends PathCondition implements ICondition<CellGroup> {

    public NoLoopCondition(Neighborhood neighborhood) {
        super(neighborhood);
    }

    @Override
    public boolean check(CellGroup cellGroup) {
        List<Cell> cells = cellGroup.getCells();
        List<Cell> branchedOffCells = getBranchedOffCells(cells);
        cells.removeAll(branchedOffCells);
        boolean check = cells.isEmpty();
        if (!check) {
            String message = cells
                    .stream()
                    .map(cell -> cell.getCoordinate().toString())
                    .reduce("Loop/s detected: ", (s1, s2) -> s1 + " " + s2);
            printError(message);
        }
        return check;
    }

    private void printError(String message) {
        message = "============= FAILED =============\n" +
                "Condition: NoLoopCondition\n" +
                message;
        System.out.println(message);
    }

}
