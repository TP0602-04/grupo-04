package ar.fiuba.tdd.pgotuzzo.rule.collector;

import ar.fiuba.tdd.pgotuzzo.IBoard;
import ar.fiuba.tdd.pgotuzzo.rule.CellGroup;

import java.util.ArrayList;
import java.util.List;

public class AllCollector implements ICollector<CellGroup> {
    @Override
    public List<CellGroup> collect(IBoard board) {
        List<CellGroup> groups = new ArrayList<>();
        CellGroup cellGroup = new CellGroup(board.getCells());
        groups.add(cellGroup);
        return groups;
    }
}
