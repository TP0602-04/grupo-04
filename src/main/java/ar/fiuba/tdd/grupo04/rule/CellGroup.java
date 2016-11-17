package ar.fiuba.tdd.grupo04.rule;

import ar.fiuba.tdd.grupo04.board.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CellGroup {
    private List<Cell> cells;

    public CellGroup(List<Cell> cells) {
        this.cells = new ArrayList<>();
        this.cells.addAll(cells);
    }

    public List<Cell> getCells() {
        return cells;
    }

    public List<Cell> getFilledCells() {
        return cells
                .stream()
                .filter(cell -> cell.getValue() != null)
                .collect(Collectors.toList());
    }

}
