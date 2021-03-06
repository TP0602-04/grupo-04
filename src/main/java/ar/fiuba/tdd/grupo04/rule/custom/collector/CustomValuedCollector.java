package ar.fiuba.tdd.grupo04.rule.custom.collector;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.board.Reference;
import ar.fiuba.tdd.grupo04.rule.CellGroup;
import ar.fiuba.tdd.grupo04.rule.collector.ValuedCollector;
import ar.fiuba.tdd.grupo04.rule.custom.ReferencedCellGroup;

import java.util.ArrayList;
import java.util.List;

public class CustomValuedCollector implements ICustomCollector {
    private ValuedCollector valuedCollector;

    public CustomValuedCollector(List<Integer> filterValues) {
        this.valuedCollector = new ValuedCollector(filterValues);
    }

    @Override
    public List<ReferencedCellGroup> collect(IBoard board) {
        List<Reference> references = board.getReferences();
        List<ReferencedCellGroup> cellGroups = new ArrayList<>();
        references.forEach(
                reference -> {
                List<Integer> values = reference.getValues();
                List<Cell> source = reference.getCells();
                CellGroup filteredCells = valuedCollector.collect(source);
                ReferencedCellGroup group = new ReferencedCellGroup(filteredCells.getCells(), values);
                cellGroups.add(group);
            }
        );
        return cellGroups;
    }

}
