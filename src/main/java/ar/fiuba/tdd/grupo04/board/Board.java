package ar.fiuba.tdd.grupo04.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board<T> implements IBoard<T> {
    List<List<Optional<T>>> cells;

    public Board(Integer rows, Integer columns) {
        this.cells = new ArrayList<>();
        this.initCells(rows, columns);
    }

    private void initCells(Integer rows, Integer columns) {
        for (Integer row = 0; row < rows; row++) {
            List rowList = new ArrayList<>();
            this.cells.add(rowList);
            for (Integer column = 0; column < columns; column++) {
                rowList.add(Optional.empty());
            }
        }
    }

    @Override
    public void put(T value, Coordinate coordinate) {
        cells.get(coordinate.row()).set(coordinate.column(), Optional.ofNullable(value));
    }


    @Override
    public Optional<T> get(Coordinate coordinate) {
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
