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
    protected String getConditionName() {
        return SingleLoopCondition.class.getSimpleName();
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
            printError(bifurcations);
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

}
