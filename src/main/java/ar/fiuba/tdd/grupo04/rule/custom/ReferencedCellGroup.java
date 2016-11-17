package ar.fiuba.tdd.grupo04.rule.custom;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

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
