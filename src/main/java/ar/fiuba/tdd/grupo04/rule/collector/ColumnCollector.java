package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ColumnCollector implements ICollector {

    @Override
    public List<CellGroup> collect(IBoard board) {
        List<CellGroup> cellGroups = new ArrayList<>();
        int size = board.getColumnSize();
        for (int i = 0; i < size; i++) {
            final int columnIndex = i;
            List<Cell> column = board.getCells().stream()
                    .filter(cell ->
                            cell.getCoordinate().column() == columnIndex
                    )
                    .collect(Collectors.toList());
            cellGroups.add(new CellGroup(column));
        }
        return cellGroups;
    }

}
