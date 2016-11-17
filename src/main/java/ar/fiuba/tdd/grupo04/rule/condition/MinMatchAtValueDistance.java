package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.Coordinate;
import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MinMatchAtValueDistance implements ICondition {
    @Override
    public boolean check(CellGroup cellGroup) {
        List<Cell> filledCells = cellGroup.getFilledCells();
        List<Cell> problematicCells = filledCells.stream()
                .map(cell -> checkCell(cell, filledCells))
                .reduce(new ArrayList<>(),
                        (list, otherList) -> {
                            otherList.forEach(cell -> {
                                if (!list.contains(cell)) {
                                    list.add(cell);
                                }
                            });
                            return list;
                        });
        boolean check = problematicCells.isEmpty();
        if (!check) {
            String message = problematicCells
                    .stream()
                    .map(cell -> cell.getCoordinate().toString())
                    .reduce("Problematic cells: ", (s1, s2) -> s1 + " " + s2);
            printError(message);
        }
        return check;
    }

    private List<Cell> checkCell(Cell current, List<Cell> cells) {
        return cells.stream()
                .filter(potential -> current != potential)
                .filter(potential -> current.getValue().equals(potential.getValue()))
                .filter(potential -> isSameRowOrColumn(current, potential))
                .filter(potential -> current.distance(potential) < current.getValue())
                .collect(Collectors.toList());
    }

    private boolean isSameRowOrColumn(Cell cell, Cell otherCell) {
        Coordinate coordinate = cell.getCoordinate();
        Coordinate otherCoordinate = otherCell.getCoordinate();
        return coordinate.row() == otherCoordinate.row() ||
                coordinate.column() == otherCoordinate.column();
    }

    private void printError(String message) {
        message = "============= FAILED =============\n" +
                "Condition: MinMatchAtValueDistance\n" +
                message;
        System.out.println(message);
    }

}
