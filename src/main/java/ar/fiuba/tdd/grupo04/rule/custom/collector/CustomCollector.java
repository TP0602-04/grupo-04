package ar.fiuba.tdd.grupo04.rule.custom.collector;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.board.Reference;
import ar.fiuba.tdd.grupo04.rule.custom.ReferencedCellGroup;

import java.util.List;
import java.util.stream.Collectors;

public class CustomCollector implements ICustomCollector {
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
        List<Integer> values = reference.getValues();
        return new ReferencedCellGroup(cells, values);
    }
}
