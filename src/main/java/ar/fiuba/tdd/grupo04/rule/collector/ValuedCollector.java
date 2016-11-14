package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ValuedCollector implements ICollector<CellGroup> {
    private List<Integer> filterValues;

    public ValuedCollector(List<Integer> filterValues) {
        this.filterValues = filterValues;
    }

    @Override
    public List<CellGroup> collect(IBoard board) {
        List<CellGroup> cellGroups = new ArrayList<>();
        cellGroups.add(collect(board.getCells()));
        return cellGroups;
    }

    public CellGroup collect(List<Cell> source) {
        List<Cell> cells = source
                .stream()
                .filter(cell -> cell.getValue() != null)
                .filter(cell -> filterValues.contains(cell.getValue()))
                .collect(Collectors.toList());
        return new CellGroup(cells);
    }
}
