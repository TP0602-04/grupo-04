package ar.fiuba.tdd.grupo04.board;

import ar.fiuba.tdd.grupo04.Coordinate;
import ar.fiuba.tdd.grupo04.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board implements IBoard {
    private int rowSize;
    private int columnSize;
    private List<Cell> cells;
    private List<Slot> slots;

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
        slots = new ArrayList<>();
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
            throw new IndexOutOfBoundsException("Error retrieving a cell. Coordinate out of bound\nCoordinate = " + coordinate.toString());
        }
        return cells
                .stream()
                .filter(cell -> cell.getCoordinate().equals(coordinate))
                .findFirst()
                .get();
    }

    @Override
    public List<Cell> getCells() {
        List<Cell> cellList = new ArrayList<>();
        cellList.addAll(cells);
        return cellList;
    }

    @Override
    public void fill(Input input) {
        final Coordinate coordinate = input.getCoordinate();
        final Integer value = input.getValue();
        if (!checkBounds(coordinate)) {
            throw new IndexOutOfBoundsException("Error filling a cell. Coordinate out of bound\nCoordinate = " + coordinate.toString());
        }
        cells.stream()
                .filter(cell -> coordinate.equals(cell.getCoordinate()))
                .findFirst()
                .get()
                .setValue(value);
    }

    @Override
    public void lockCell(Coordinate coordinate) {
        cells.stream()
                .filter(cell -> coordinate.equals(cell.getCoordinate()))
                .forEach(cell -> cell.edit(false));
    }

    @Override
    public List<Reference> getReferences() {
        return slots.stream()
                .map(this::referenceFromSlot)
                .collect(Collectors.toList());
    }

    @Override
    public void addReference(Slot slot) {
        this.slots.add(slot);
    }

    @Override
    public String toString() {
        String boardToString = "BOARD:\n";
        for (int i = 0; i < rowSize; i++) {
            boardToString = boardToString + "\t==========================================================================\n";
            for (int j = 0; j < columnSize; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Integer value = getCell(coordinate).getValue();
                String stringValue = value == null ? "" : value.toString();
                boardToString = boardToString + "\t|\t" + stringValue;
            }
            boardToString = boardToString + "\t|\t\n";
        }
        boardToString = boardToString + "\t==========================================================================";
        return boardToString;
    }

    private boolean checkBounds(Coordinate coordinate) {
        int row = coordinate.row();
        int column = coordinate.column();
        return row >= 0 && row < rowSize && column >= 0 && column < columnSize;
    }

    private Reference referenceFromSlot(Slot slot) {
        List<Cell> cellList = slot.getCoordinates()
                .stream()
                .map(this::getCell)
                .collect(Collectors.toList());
        return new Reference(cellList, slot.getValues());
    }
}
