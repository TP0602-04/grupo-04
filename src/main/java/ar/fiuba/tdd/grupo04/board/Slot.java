package ar.fiuba.tdd.grupo04.board;

import ar.fiuba.tdd.grupo04.Coordinate;

import java.util.List;

public class Slot extends ValuesHolder<Coordinate> {

    public Slot(List<Coordinate> coordinates, List<Integer> values) {
        super(coordinates, values);
    }

    public List<Coordinate> getCoordinates() {
        return things;
    }
}
