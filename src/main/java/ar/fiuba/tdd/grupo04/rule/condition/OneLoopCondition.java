package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OneLoopCondition<R extends IInputGroup<Boolean>> implements ICondition<R> {

    private final Function<Coordinate, Boolean> isSegment;
    private final Function<Coordinate, Boolean> isCell;

    public OneLoopCondition(Function<Coordinate, Boolean> isCell, Function<Coordinate, Boolean> isSegment) {
        this.isCell = isCell;
        this.isSegment = isSegment;
    }

    @Override
    public boolean check(R inputGroup) {
        final List<IInput<Boolean>> inputs = inputGroup.getInputs();
        final List<Coordinate> markedInputs = inputs.stream().filter(i -> i.getValue().isPresent()).filter(i -> i.getValue().get()).map(IInput::getCoordinate).collect(Collectors.toList());

        List<Coordinate> path = new ArrayList<>();
        Optional<Coordinate> firstCell = getFirstCell(markedInputs);
        Optional<Coordinate> actualCell = firstCell;

        if (!actualCell.isPresent()) {
            return false;
        }
        path.add(actualCell.get());

        Optional<Coordinate> actualSegment = getNextSegment(markedInputs, actualCell.get());
        if (!actualSegment.isPresent()) {
            return false;
        }
        path.add(actualSegment.get());

        boolean findNextStep = true;
        while (findNextStep) {
            actualCell = getNextCell(actualSegment.get(), actualCell.get());
            if (!actualCell.isPresent()) {
                return false;
            } else if (firstCell.equals(actualCell.get()) ) {
                // End of the loop
                findNextStep = false;
            } else if (path.contains(actualCell.get())) {
                // There is not only one loop
                return false;
            } else {
                path.add(actualCell.get());

                actualSegment = getNextSegment(markedInputs, actualCell.get(), actualSegment.get());
                if (!actualSegment.isPresent()) {
                    return false;
                }
                path.add(actualSegment.get());
            }

        }
        // Check if there is only one loop all inputs are in path
        return path.size() == markedInputs.size();
    }

    private Optional<Coordinate> getNextCell(Coordinate actualSegment, Coordinate actualCell) {
        Integer newColumn = 2 * actualSegment.column() - actualCell.column();
        Integer newRow = 2 * actualSegment.row() - actualCell.row();
        if (newRow < 0 || newColumn < 0) {
            return Optional.empty();
        }
        return Optional.of(new Coordinate(newRow, newColumn));
    }

    private Optional<Coordinate> getNextSegment(List<Coordinate> coordinates, Coordinate actualCell) {
        Coordinate nextCoordinate = new Coordinate(actualCell.row() + 1,actualCell.column());
        if (coordinates.contains(nextCoordinate)) {
            return Optional.of(nextCoordinate);
        } else {
            nextCoordinate = new Coordinate(actualCell.row() - 1,actualCell.column());
            if (coordinates.contains(nextCoordinate)) {
                return Optional.of(nextCoordinate);
            } else {
                nextCoordinate = new Coordinate(actualCell.row(),actualCell.column() + 1);
                if (coordinates.contains(nextCoordinate)) {
                    return Optional.of(nextCoordinate);
                } else {
                    nextCoordinate = new Coordinate(actualCell.row(),actualCell.column() - 1);
                    if (coordinates.contains(nextCoordinate)) {
                        return Optional.of(nextCoordinate);
                    }
                }
            }
        }
        return Optional.empty();
    }

    private Optional<Coordinate> getNextSegment(List<Coordinate> coordinates, Coordinate actualCell, Coordinate actualSegment) {
        Coordinate nextCoordinate = new Coordinate(actualCell.row() + 1,actualCell.column());
        if (coordinates.contains(nextCoordinate) && !nextCoordinate.equals(actualSegment)) {
            return Optional.of(nextCoordinate);
        } else {
            nextCoordinate = new Coordinate(actualCell.row() - 1,actualCell.column());
            if (coordinates.contains(nextCoordinate) && !nextCoordinate.equals(actualSegment)) {
                return Optional.of(nextCoordinate);
            } else {
                nextCoordinate = new Coordinate(actualCell.row(),actualCell.column() + 1);
                if (coordinates.contains(nextCoordinate) && !nextCoordinate.equals(actualSegment)) {
                    return Optional.of(nextCoordinate);
                } else {
                    nextCoordinate = new Coordinate(actualCell.row(),actualCell.column() - 1);
                    if (coordinates.contains(nextCoordinate) && !nextCoordinate.equals(actualSegment)) {
                        return Optional.of(nextCoordinate);
                    }
                }
            }
        }
        return Optional.empty();
    }

    private Optional<Coordinate> getFirstCell(List<Coordinate> coordinates) {
        Optional firstCell = Optional.empty();
        for (Coordinate coordinate : coordinates) {
            if (isCell.apply(coordinate)) {
                firstCell = Optional.of(coordinate);
            }
        }
        return firstCell;
    }
}
