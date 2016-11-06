package ar.fiuba.tdd.pgotuzzo.rule;

import ar.fiuba.tdd.pgotuzzo.Cell;

import java.util.List;

public class CellGroup {

    private List<Cell> cells;

    public CellGroup(List<Cell> cells) {
        this.cells = cells;
    }

    public List<Cell> getCells() {
        return cells;
    }

}
