package ar.fiuba.tdd.pgotuzzo.rule.condition;

import ar.fiuba.tdd.pgotuzzo.Coordinate;
import ar.fiuba.tdd.pgotuzzo.board.Cell;
import ar.fiuba.tdd.pgotuzzo.rule.CellGroup;

import java.util.List;
import java.util.stream.Collectors;

public class LoopCondition implements ICondition<CellGroup> {

    @Override
    public boolean check(CellGroup cellGroup) {
        List<Cell> filledCells = cellGroup.getFilledCells();
        List<Coordinate> coordinateList = filledCells
                .stream()
                .map(Cell::getCoordinate)
                .collect(Collectors.toList());
        filledCells
                .stream()
                .map(Cell::getCoordinate)
                .map(coordinate -> hasTwoConsecutives(coordinate, coordinateList))
                .reduce(true, (b1, b2) -> b1 && b2);
        return false;
    }

    private boolean hasTwoConsecutives(Coordinate coordinate, List<Coordinate> coordinateList) {
        // Remove if it exists
        coordinateList.remove(coordinate);
        // Check the draw is a really closed loop
        long contiguousAmount = coordinateList.stream()
                .filter(coordinate1 -> isConsecutive(coordinate1, coordinate))
                .count();
        return contiguousAmount >= 2;
    }

    private boolean isConsecutive(Coordinate coordinate1, Coordinate coordinate2) {
        int deltaRow = Math.abs(coordinate1.row() - coordinate2.row());
        int deltaColumn = Math.abs(coordinate1.column() - coordinate2.column());
        return deltaColumn + deltaRow == 1;
    }

}
