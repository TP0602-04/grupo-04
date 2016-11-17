package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.neighborhood.Neighborhood;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.List;
import java.util.stream.Collectors;

public class NoBranchedOffCondition extends PathCondition implements ICondition {
    private int filterValue;

    public NoBranchedOffCondition(Neighborhood neighborhood, int filterValue) {
        super(neighborhood);
        this.filterValue = filterValue;
    }

    @Override
    protected String getConditionName() {
        return NoBranchedOffCondition.class.getSimpleName();
    }

    @Override
    public boolean check(CellGroup cellGroup) {
        List<Cell> cells = cellGroup.getCells();
        List<Cell> branchedOffCells = getBranchedOffCells(cells).stream()
                .filter(cell -> cell.getValue() == filterValue)
                .collect(Collectors.toList());

        boolean check = branchedOffCells.isEmpty();
        if (!check) {
            printError(branchedOffCells);
        }
        return check;
    }

}
