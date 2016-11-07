package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RowCollector implements ICollector<CellGroup> {

    @Override
    public List<CellGroup> collect(IBoard board) {
        List<CellGroup> cellGroups = new ArrayList<>();
        int size = board.getRowSize();
        for (int i = 0; i < size; i++) {
            final int rowIndex = i;
            List<Cell> row = board.getCells().stream()
                    .filter(cell ->
                            cell.getCoordinate().row() == rowIndex
                    )
                    .collect(Collectors.toList());
            cellGroups.add(new CellGroup(row));
        }
        return cellGroups;
    }

}
