package ar.fiuba.tdd.pgotuzzo.board;

import ar.fiuba.tdd.pgotuzzo.Coordinate;
import ar.fiuba.tdd.pgotuzzo.Input;

import java.util.List;

public interface IBoard {

    int getRowSize();

    int getColumnSize();

    Cell getCell(Coordinate coordinate);

    List<Cell> getCells();

    void fill(Input input);

    void lockCell(Coordinate coordinate);

    List<Reference> getReferences();

    void addReference(Slot slot);

}
