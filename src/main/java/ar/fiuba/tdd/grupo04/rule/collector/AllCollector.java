package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.ArrayList;
import java.util.List;

public class AllCollector implements ICollector {
    @Override
    public List<CellGroup> collect(IBoard board) {
        List<CellGroup> groups = new ArrayList<>();
        CellGroup cellGroup = new CellGroup(board.getCells());
        groups.add(cellGroup);
        return groups;
    }
}
