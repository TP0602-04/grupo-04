package ar.fiuba.tdd.grupo04.neighborhood;

import ar.fiuba.tdd.grupo04.board.Cell;

public class StraightNeighborhood implements Neighborhood {
    @Override
    public boolean areNeighbors(Cell cell1, Cell cell2) {
        return cell1.distance(cell2) == 1.0;
    }
}
