package ar.fiuba.tdd.grupo04.board.reference;

import ar.fiuba.tdd.grupo04.board.Coordinate;

import java.util.List;

public interface IReferencedGroup<S> {
    S getValue();

    List<Coordinate> getCoordinates();
}
