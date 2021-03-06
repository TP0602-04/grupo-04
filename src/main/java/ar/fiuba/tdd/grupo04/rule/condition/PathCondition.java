package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.neighborhood.Neighborhood;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class PathCondition extends Condition {

    private Neighborhood neighborhood;

    public PathCondition(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    protected List<Cell> getBifurcations(List<Cell> cells) {
        return cells.stream()
                .filter(cell -> neighborhood.getNeighbors(cell, cells).size() > 2)
                .collect(Collectors.toList());
    }

    protected List<Cell> getBranchedOffCells(List<Cell> cells) {
        return getBranchedOffCells(new ArrayList<>(), cells);
    }

    private List<Cell> getBranchedOffCells(List<Cell> branched, List<Cell> cells) {
        List<Cell> newBranchedCells = cells.stream()
                .filter(cell -> neighborhood.getNeighbors(cell, cells).size() < 2)
                .collect(Collectors.toList());
        // Exit Condition
        if (newBranchedCells.isEmpty()) {
            return branched;
        }
        // Add to the accumulator
        branched.addAll(newBranchedCells);
        // Remove for cells and retry
        cells.removeAll(newBranchedCells);
        return getBranchedOffCells(branched, cells);
    }

}
