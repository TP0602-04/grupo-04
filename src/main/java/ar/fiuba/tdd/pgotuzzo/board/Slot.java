package ar.fiuba.tdd.pgotuzzo.board;

import ar.fiuba.tdd.pgotuzzo.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class Slot {
    private List<Coordinate> coordinates;
    private Integer value;

    public Slot(List<Coordinate> coordinates, Integer value) {
        this.coordinates = new ArrayList<>();
        this.coordinates.addAll(coordinates);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }
}
