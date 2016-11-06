package ar.fiuba.tdd.pgotuzzo;

import java.util.List;

public interface IBoard {

    int getRowSize();

    int getColumnSize();

    Cell getCell(Coordinate coordinate);

    List<Cell> getCells();

    void fill(Input input);

    void lockCell(Coordinate coordinate);

}
