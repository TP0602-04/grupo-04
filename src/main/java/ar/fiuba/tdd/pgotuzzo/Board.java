package ar.fiuba.tdd.pgotuzzo;

import java.util.ArrayList;
import java.util.List;

public class Board implements IBoard {
    private int rowSize;
    private int columnSize;
    private List<Cell> cells;

    public Board(int rowSize, int columnSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        cells = new ArrayList<>();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Cell cell = new Cell(coordinate);
                cells.add(cell);
            }
        }
    }

    @Override
    public int getRowSize() {
        return rowSize;
    }

    @Override
    public int getColumnSize() {
        return columnSize;
    }

    @Override
    public Cell getCell(Coordinate coordinate) {
        if (!checkBounds(coordinate)) {
            throw new IndexOutOfBoundsException();
        }
        return cells
                .stream()
                .filter(cell ->
                        cell.getCoordinate().equals(coordinate)
                )
                .findFirst()
                .get();
    }

    @Override
    public List<Cell> getCells() {
        return cells;
    }

    private boolean checkBounds(Coordinate coordinate) {
        int row = coordinate.row();
        int column = coordinate.column();
        return row >= 0 && row < rowSize && column >= 0 && column < columnSize;
    }

}
