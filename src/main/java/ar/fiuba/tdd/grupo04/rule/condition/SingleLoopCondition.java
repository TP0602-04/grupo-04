package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.neighborhood.Neighborhood;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.List;

public class SingleLoopCondition extends PathCondition implements ICondition {

    public SingleLoopCondition(Neighborhood neighborhood) {
        super(neighborhood);
    }

    @Override
    public boolean check(CellGroup cellGroup) {
        String errorMessage;
        List<Cell> cells = cellGroup.getCells();

        // Remove Branched cells
        List<Cell> branchedOffCells = getBranchedOffCells(cells);
        cells.removeAll(branchedOffCells);

        // Check Bifurcations
        List<Cell> bifurcations = getBifurcations(cells);
        if (!bifurcations.isEmpty()) {
            errorMessage = bifurcations
                    .stream()
                    .map(cell -> cell.getCoordinate().toString())
                    .reduce("More than one loop...Check bifurcations: ", (s1, s2) -> s1 + " " + s2);
            printError(errorMessage);
            return false;
        }

        // Check existing Loop
        boolean check = !cells.isEmpty();
        if (!check) {
            errorMessage = "There is NO loop!";
            printError(errorMessage);
            return false;
        }
        return true;
    }

    private void printError(String message) {
        message = "============= FAILED =============\n" 
                + "Condition: SingleLoopCondition\n" 
                + message;
        System.out.println(message);
    }
}
