package ar.fiuba.tdd.pgotuzzo.rule;

import ar.fiuba.tdd.pgotuzzo.board.Cell;

import java.util.List;

public class ReferencedCellGroup extends CellGroup {
    private Integer refrencedValue;

    public ReferencedCellGroup(List<Cell> cells, Integer value) {
        super(cells);
        refrencedValue = value;
    }

    public Integer getRefrencedValue() {
        return refrencedValue;
    }

}
