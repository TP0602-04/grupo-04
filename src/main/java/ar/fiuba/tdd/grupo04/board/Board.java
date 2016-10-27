package ar.fiuba.tdd.grupo04.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board<T> implements IBoard<T> {
    private List<List<IInput<T>>> cells;

    public Board(Integer rows, Integer columns) {
        this.cells = new ArrayList<>();
        this.initCells(rows, columns, null);
    }

    public Board(Integer rows, Integer columns, T initialValue) {
        this.cells = new ArrayList<>();
        this.initCells(rows, columns, initialValue);
    }

    private void initCells(Integer rows, Integer columns, T initialValue) {
        for (Integer row = 0; row < rows; row++) {
            List<IInput<T>> rowList = new ArrayList<>();
            this.cells.add(rowList);
            for (Integer column = 0; column < columns; column++) {
                rowList.add(new Input<T>(initialValue, new Coordinate(row, column)));
            }
        }
    }

    @Override
    public void put(T value, Coordinate coordinate) {
        // viola inv de dependencia dsp hacer un factory o algo
        cells.get(coordinate.row()).set(coordinate.column(), new Input<T>(value, coordinate));
    }


    @Override
    public IInput<T> get(Coordinate coordinate) {
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
