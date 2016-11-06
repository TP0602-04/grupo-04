package ar.fiuba.tdd.pgotuzzo.board;

import java.util.ArrayList;
import java.util.List;

public class Reference {
    private List<Cell> cells;
    private Integer referenceValue;

    public Reference(List<Cell> cells, Integer referenceValue) {
        this.cells = new ArrayList<>();
        this.cells.addAll(cells);
        this.referenceValue = referenceValue;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public Integer getReferenceValue() {
        return referenceValue;
    }
}
