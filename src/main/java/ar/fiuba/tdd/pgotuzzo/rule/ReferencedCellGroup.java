package ar.fiuba.tdd.pgotuzzo.rule;

import ar.fiuba.tdd.pgotuzzo.board.Cell;

import java.util.List;

public class ReferencedCellGroup extends CellGroup {
    private List<Integer> referencedValues;

    public ReferencedCellGroup(List<Cell> cells, List<Integer> values) {
        super(cells);
        referencedValues = values;
    }

    public List<Integer> getReferencedValues() {
        return referencedValues;
    }

}
