package ar.fiuba.tdd.grupo04.board;

import ar.fiuba.tdd.grupo04.Coordinate;
import ar.fiuba.tdd.grupo04.Input;

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
