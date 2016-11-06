package ar.fiuba.tdd.pgotuzzo.rule.collector;

import ar.fiuba.tdd.pgotuzzo.board.Cell;
import ar.fiuba.tdd.pgotuzzo.board.IBoard;
import ar.fiuba.tdd.pgotuzzo.board.Reference;
import ar.fiuba.tdd.pgotuzzo.rule.ReferencedCellGroup;

import java.util.List;
import java.util.stream.Collectors;

public class CustomCollector implements ICollector<ReferencedCellGroup> {
    @Override
    public List<ReferencedCellGroup> collect(IBoard board) {
        return board
                .getReferences()
                .stream()
                .map(this::getReferenceCellGroup)
                .collect(Collectors.toList());
    }

    private ReferencedCellGroup getReferenceCellGroup(Reference reference) {
        List<Cell> cells = reference.getCells();
        Integer value = reference.getReferenceValue();
        return new ReferencedCellGroup(cells, value);
    }
}
