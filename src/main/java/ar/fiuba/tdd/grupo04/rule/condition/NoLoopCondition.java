package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.neighborhood.Neighborhood;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.List;

public class NoLoopCondition extends PathCondition implements ICondition {

    public NoLoopCondition(Neighborhood neighborhood) {
        super(neighborhood);
    }

    @Override
    protected String getConditionName() {
        return NoLoopCondition.class.getSimpleName();
    }

    @Override
    public boolean check(CellGroup cellGroup) {
        List<Cell> cells = cellGroup.getCells();
        List<Cell> branchedOffCells = getBranchedOffCells(cells);
        cells.removeAll(branchedOffCells);
        boolean check = cells.isEmpty();
        if (!check) {
            printError(cells);
        }
        return check;
    }

}
