package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.Coordinate;
import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoopCondition implements ICondition<CellGroup> {
    private List<Coordinate> noContinuosCells;

    public LoopCondition() {
        noContinuosCells = new ArrayList<>();
    }

    @Override
    public boolean check(CellGroup cellGroup) {
        noContinuosCells.clear();
        List<Cell> filledCells = cellGroup.getFilledCells();
        List<Coordinate> coordinateList = filledCells
                .stream()
                .map(Cell::getCoordinate)
                .collect(Collectors.toList());
        boolean check = filledCells
                .stream()
                .map(Cell::getCoordinate)
                .map(coordinate -> hasTwoConsecutive(coordinate, coordinateList))
                .reduce(true, (b1, b2) -> b1 && b2);
        if (!check) {
            String message = "============= FAILED =============\n" +
                    "Condition: LoopCondition\nCells: ";
            for (Coordinate coordinate : noContinuosCells) {
                message = message + coordinate.toString() + " ";
            }
            System.out.println(message);
        }
        return check;
    }


    private boolean hasTwoConsecutive(Coordinate coordinate, List<Coordinate> coordinateList) {
        // Copy list as it is going to be modified
        List<Coordinate> auxList = new ArrayList<>();
        auxList.addAll(coordinateList);
        // Remove if it exists
        auxList.remove(coordinate);
        long contiguousAmount = auxList.stream()
                .filter(coordinate1 -> isConsecutive(coordinate1, coordinate))
                .count();
        boolean check = contiguousAmount >= 2;
        if (!check) {
            noContinuosCells.add(coordinate);
        }
        return check;
    }

    private boolean isConsecutive(Coordinate coordinate1, Coordinate coordinate2) {
        int deltaRow = Math.abs(coordinate1.row() - coordinate2.row());
        int deltaColumn = Math.abs(coordinate1.column() - coordinate2.column());
        return (deltaColumn + deltaRow) == 1;
    }

}
