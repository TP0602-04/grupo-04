package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoopCondition implements ICondition<CellGroup> {
    private static final int MIN_LOOP_SIZE = 4;

    @Override
    public boolean check(CellGroup cellGroup) {
        List<Cell> path = cellGroup.getCells();
        // Min loop size check
        if (path.size() < MIN_LOOP_SIZE) {
            printError("Min loop size: " + MIN_LOOP_SIZE);
            return false;
        }
        // Branched cells check
        List<Cell> branchedCells = getBranchedOffCells(path);
        if (!branchedCells.isEmpty()) {
            String message = "Branched cells: ";
            for (Cell cell : branchedCells) {
                message = message + cell.getCoordinate().toString() + " ";
            }
            printError(message);
            return false;
        }
        // Root cell -> the first cell in the list
        Cell rootCell = path.get(0);
        // Root cell neighbor
        Cell current = getNeighbor(rootCell, path).get(0);
        // Path cells minus the "root" and "current" cells
        path.remove(rootCell);
        path.remove(current);
        boolean check = check(rootCell, current, path);
        if (!check) {
            printError("This is not a simple loop!");
        }
        return check;
    }

    private boolean check(Cell rootCell, Cell current, List<Cell> path) {
        // Success case
        if (path.size() == 0 && areNeighbor(current, rootCell)) {
            return true;
        }
        // Recursive call
        List<Cell> neighbors = getNeighbor(current, path);
        return neighbors.stream()
                .map(cell -> {
                            List<Cell> pathCopy = new ArrayList<>();
                            pathCopy.addAll(path);
                            pathCopy.remove(cell);
                            return check(rootCell, cell, pathCopy);
                        }
                )
                .reduce(false, (b1, b2) -> b1 || b2);
    }

    private List<Cell> getBranchedOffCells(List<Cell> cells) {
        return cells
                .stream()
                .filter(cell -> getNeighbor(cell, cells).size() < 2)
                .collect(Collectors.toList());
    }

    private List<Cell> getNeighbor(Cell cell, List<Cell> potentialNeighbors) {
        return potentialNeighbors
                .stream()
                .filter(potential -> areNeighbor(cell, potential))
                .collect(Collectors.toList());
    }

    private boolean areNeighbor(Cell cell1, Cell cell2) {
        return cell1.distance(cell2) == 1.0;
    }

    private void printError(String message) {
        message = "============= FAILED =============\n" +
                "Condition: LoopCondition\n" +
                message;
        System.out.println(message);
    }

}


