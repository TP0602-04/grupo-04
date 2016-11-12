package ar.fiuba.tdd.grupo04.model.board.reference;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class ReferencedBlockGroup implements IReferencedGroup<Integer> {
    private List<Coordinate> coordinates;
    private Integer value;

    public ReferencedBlockGroup(List<Coordinate> coordinates, Integer value) {
        this.coordinates = coordinates;
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public List<Coordinate> getCoordinates() {
        return coordinates;
    }
}


