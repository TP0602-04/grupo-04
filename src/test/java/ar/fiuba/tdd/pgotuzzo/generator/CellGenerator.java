package ar.fiuba.tdd.pgotuzzo.generator;

import ar.fiuba.tdd.pgotuzzo.board.Cell;

import java.util.ArrayList;
import java.util.List;

import static ar.fiuba.tdd.pgotuzzo.generator.CoordinateGenerator.getCoordinate;
import static ar.fiuba.tdd.pgotuzzo.generator.CoordinateGenerator.getCoordinateList;
import static ar.fiuba.tdd.pgotuzzo.generator.IntGenerator.getInt;

public class CellGenerator {

    public static Cell getEmptyCell() {
        return new Cell(getCoordinate());
    }

    public static List<Cell> getCellList(int listSize) {
        List<Cell> cells = new ArrayList<>();
        getCoordinateList(listSize).forEach(
                coordinate -> {
                    int value = getInt();
                    Cell cell = new Cell(coordinate, value);
                    cells.add(cell);
                });
        return cells;
    }

    public static List<Cell> getCellListWithDefaultValue(int listSize, int defaultValue) {
        List<Cell> cells = new ArrayList<>();
        getCoordinateList(listSize).forEach(
                coordinate -> {
                    Cell cell = new Cell(coordinate, defaultValue);
                    cells.add(cell);
                });
        return cells;
    }


}
