package ar.fiuba.tdd.grupo04.neighborhood;

import ar.fiuba.tdd.grupo04.board.Cell;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Neighborhood {
    abstract boolean areNeighbors(Cell cell1, Cell cell2);

    public List<Cell> getNeighbors(Cell cell, List<Cell> potentialNeighbors) {
        return potentialNeighbors
                .stream()
                .filter(potential -> areNeighbors(cell, potential))
                .collect(Collectors.toList());
    }
}
