package ar.fiuba.tdd.pgotuzzo.rule.collector;

import ar.fiuba.tdd.pgotuzzo.board.Cell;
import ar.fiuba.tdd.pgotuzzo.board.IBoard;
import ar.fiuba.tdd.pgotuzzo.board.Reference;
import ar.fiuba.tdd.pgotuzzo.rule.CellGroup;
import ar.fiuba.tdd.pgotuzzo.rule.ReferencedCellGroup;

import java.util.ArrayList;
import java.util.List;

public class CustomValuedCollector implements ICollector<ReferencedCellGroup> {
    private ValuedCollector valuedCollector;

    public CustomValuedCollector(int filterValue) {
        this.valuedCollector = new ValuedCollector(filterValue);
    }

    @Override
    public List<ReferencedCellGroup> collect(IBoard board) {
        List<Reference> references = board.getReferences();
        List<ReferencedCellGroup> cellGroups = new ArrayList<>();
        references.forEach(reference -> {
            List<Integer> values = reference.getReferenceValues();
            List<Cell> source = reference.getCells();
            CellGroup filteredCells = valuedCollector.collect(source);
            ReferencedCellGroup group = new ReferencedCellGroup(filteredCells.getCells(), values);
            cellGroups.add(group);
        });
        return cellGroups;
    }

}
