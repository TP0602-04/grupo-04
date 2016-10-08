package ar.fiuba.tdd.grupo04.board;

import java.util.ArrayList;
import java.util.List;

public class Board<T> implements IBoard<T> {
    List<List<T>> cells;

    public Board(Integer rows, Integer columns) {
        this.cells = new ArrayList<>();
        this.initCells(rows, columns);
    }

    private void initCells(Integer rows, Integer columns) {
        for (Integer row = 0; row < rows; row++) {
            List<T> rowList = new ArrayList<T>();
            this.cells.add(rowList);
            for (Integer column = 0; column < columns; column++) {
                rowList.add(null);
            }
        }
    }

    @Override
    public void put(T value, Coordinate coordinate) {
        cells.get(coordinate.row()).set(coordinate.column(), value);
    }


    @Override
    public T get(Coordinate coordinate) {
        return cells.get(coordinate.row()).get(coordinate.column());
    }

    @Override
    public Integer rowsLength() {
        return this.cells.size();
    }

    @Override
    public Integer columnsLength() {
        return this.cells.get(0).size();
    }
}
