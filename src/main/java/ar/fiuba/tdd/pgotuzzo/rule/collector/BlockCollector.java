package ar.fiuba.tdd.pgotuzzo.rule.collector;

import ar.fiuba.tdd.pgotuzzo.board.Cell;
import ar.fiuba.tdd.pgotuzzo.board.IBoard;
import ar.fiuba.tdd.pgotuzzo.rule.CellGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BlockCollector implements ICollector<CellGroup> {
    private int size;

    public BlockCollector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = size;
    }

    @Override
    public List<CellGroup> collect(IBoard board) {
        if (!checkBoardSize(board)) {
            throw new IllegalArgumentException("The board rows/columns count must be multiplier of collector's size");
        }
        int blockPerRow = board.getRowSize() / size;
        int blockPerColumn = board.getColumnSize() / size;
        List<CellGroup> cellGroups = new ArrayList<>();
        for (int i = 0; i < blockPerRow; i++) {
            for (int j = 0; j < blockPerColumn; j++) {
                final int rowBlock = i;
                final int columnBlock = j;
                List<Cell> block = board.getCells().stream()
                        .filter(cell -> filter(rowBlock, columnBlock, cell))
                        .collect(Collectors.toList());
                cellGroups.add(new CellGroup(block));
            }
        }
        return cellGroups;
    }

    private boolean checkBoardSize(IBoard board) {
        return board.getColumnSize() % size == 0 &&
                board.getRowSize() % size == 0;
    }

    private boolean filter(int blockRow, int blockColumn, Cell cell) {
        int rowLowBound = blockRow * size;
        int rowHiBound = rowLowBound + size;
        int columnLowBound = blockColumn * size;
        int columnHiBound = columnLowBound + size;

        int row = cell.getCoordinate().row();
        int column = cell.getCoordinate().column();

        return row >= rowLowBound && row < rowHiBound &&
                column >= columnLowBound && column < columnHiBound;
    }

}
