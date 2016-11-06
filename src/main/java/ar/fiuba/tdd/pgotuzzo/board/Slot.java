package ar.fiuba.tdd.pgotuzzo.board;

import ar.fiuba.tdd.pgotuzzo.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class Slot {
    private List<Coordinate> coordinates;
    private List<Integer> values;

    public Slot(List<Coordinate> coordinates, List<Integer> values) {
        this.coordinates = new ArrayList<>();
        this.coordinates.addAll(coordinates);
        this.values = values;
    }

    public List<Integer> getValues() {
        return values;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }
}
