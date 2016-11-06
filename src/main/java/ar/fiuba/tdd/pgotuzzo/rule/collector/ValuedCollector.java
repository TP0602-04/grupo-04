package ar.fiuba.tdd.pgotuzzo.rule.collector;

import ar.fiuba.tdd.pgotuzzo.board.Cell;
import ar.fiuba.tdd.pgotuzzo.board.IBoard;
import ar.fiuba.tdd.pgotuzzo.rule.CellGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ValuedCollector implements ICollector<CellGroup> {
    private int filterValue;

    public ValuedCollector(int filterValue) {
        this.filterValue = filterValue;
    }

    @Override
    public List<CellGroup> collect(IBoard board) {
        List<CellGroup> cellGroups = new ArrayList<>();
        List<Cell> cells = board
                .getCells()
                .stream()
                .filter(cell -> cell.getValue() != null)
                .filter(cell -> cell.getValue().equals(filterValue))
                .collect(Collectors.toList());
        cellGroups.add(new CellGroup(cells));
        return cellGroups;
    }
}
