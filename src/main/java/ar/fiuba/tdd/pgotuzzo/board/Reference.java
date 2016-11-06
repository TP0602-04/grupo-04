package ar.fiuba.tdd.pgotuzzo.board;

import java.util.ArrayList;
import java.util.List;

public class Reference {
    private List<Cell> cells;
    private List<Integer> referenceValues;

    public Reference(List<Cell> cells, List<Integer> referenceValues) {
        this.cells = new ArrayList<>();
        this.cells.addAll(cells);
        this.referenceValues = referenceValues;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public List<Integer> getReferenceValues() {
        return referenceValues;
    }
}
