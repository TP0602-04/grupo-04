package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GridCollector implements ICollector {
    public enum Filter {
        COLUMN,
        ROW
    }

    private Filter filter;

    public GridCollector(Filter filter) {
        this.filter = filter;
    }

    @Override
    public List<CellGroup> collect(IBoard board) {
        List<CellGroup> cellGroups = new ArrayList<>();
        int size = getDimension(board);
        for (int i = 0; i < size; i++) {
            final int index = i;
            List<Cell> match = board.getCells().stream()
                    .filter(cell -> filter(cell, index))
                    .collect(Collectors.toList());
            cellGroups.add(new CellGroup(match));
        }
        return cellGroups;
    }

    private int getDimension(IBoard board) {
        switch (filter) {
            case COLUMN:
                return board.getColumnSize();
            case ROW:
                return board.getRowSize();
            default:
                throw new RuntimeException();
        }
    }

    private boolean filter(Cell current, int index) {
        switch (filter) {
            case COLUMN:
                return current.getCoordinate().column() == index;
            case ROW:
                return current.getCoordinate().row() == index;
            default:
                throw new RuntimeException();
        }
    }

}
