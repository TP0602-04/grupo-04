package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.Coordinate;
import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MinMatchAtValueDistance extends Condition implements ICondition {

    @Override
    protected String getConditionName() {
        return MinMatchAtValueDistance.class.getSimpleName();
    }

    @Override
    public boolean check(CellGroup cellGroup) {
        List<Cell> filledCells = cellGroup.getFilledCells();
        List<Cell> problematicCells = filledCells.stream()
                .map(cell -> checkCell(cell, filledCells))
                .reduce(new ArrayList<>(),
                        (list, otherList) -> {
                            otherList.forEach(
                                    cell -> {
                                        if (!list.contains(cell)) {
                                            list.add(cell);
                                        }
                                    }
                            );
                            return list;
                        }
                );
        boolean check = problematicCells.isEmpty();
        if (!check) {
            printError(problematicCells);
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
        return coordinate.row() == otherCoordinate.row()
                || coordinate.column() == otherCoordinate.column();
    }

}
