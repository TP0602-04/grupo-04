package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.inputs.DiagonalInput;
import ar.fiuba.tdd.grupo04.inputs.IInput;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SuppressWarnings("CPD-START")
public class NoLoopsCondition<R extends IInputGroup<DiagonalInput>> implements ICondition<R> {
    private List<DiagonalInput> inputs;

    @Override
    public boolean check(R inputGroup) {
        inputs = inputGroup.getInputs().stream().filter(DiagonalInput::isFilled).filter(DiagonalInput::isDiagonal).collect(Collectors.toList());

        while (!inputs.isEmpty()) {
            final DiagonalInput input = inputs.get(0);
            if (hasLoop(input)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasLoop(DiagonalInput initialPosition) {
        return searchLoop(Optional.of(initialPosition), new ArrayList<>(), true);
    }

    private boolean searchLoop(Optional<DiagonalInput> actualPosition, List<DiagonalInput> path, boolean comesFromLeft) {
        if (!actualPosition.isPresent()) {
            return false;
        } else if (path.contains(actualPosition.get())) {
            return true;
        }

        final DiagonalInput position = actualPosition.get();
        path.add(position);
        inputs.remove(position);

        final Boolean downLeftToUpRight = position.isDownLeftToUpRight();
        final Optional<DiagonalInput> up = inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(-2,0))) && !downLeftToUpRight.equals(i.isDownLeftToUpRight())).findFirst();
        final Optional<DiagonalInput> down = inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(2,0))) && !downLeftToUpRight.equals(i.isDownLeftToUpRight())).findFirst();

        if (comesFromLeft) {
            final Optional<DiagonalInput> right = inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(0,2))) && !downLeftToUpRight.equals(i.isDownLeftToUpRight())).findFirst();
            //la diagonal va de abajo a la izquierda a arriba a la derecha
            if (downLeftToUpRight) {
                final Optional<DiagonalInput> upRight = inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(-2,2))) && !downLeftToUpRight.equals(i.isDownLeftToUpRight())).findFirst();
                return searchLoop(right, path, true) || searchLoop(up, path, false) || searchLoop(upRight, path, true);
            } else {
                final Optional<DiagonalInput> downRight = inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(2,2))) && !downLeftToUpRight.equals(i.isDownLeftToUpRight())).findFirst();
                return searchLoop(right, path, true) || searchLoop(down, path, false) || searchLoop(downRight, path, true);
            }
        }
        final Optional<DiagonalInput> left = inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(0,-2))) && !downLeftToUpRight.equals(i.isDownLeftToUpRight())).findFirst();
        //la diagonal va de abajo a la izquierda a arriba a la derecha
        if (downLeftToUpRight) {
            final Optional<DiagonalInput> downLeft = inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(2,-2))) && !downLeftToUpRight.equals(i.isDownLeftToUpRight())).findFirst();
            return searchLoop(left, path, false) || searchLoop(down, path, true) || searchLoop(downLeft, path, false);
        }
        final Optional<DiagonalInput> upLeft = inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(-2,-2))) && !downLeftToUpRight.equals(i.isDownLeftToUpRight())).findFirst();
        return searchLoop(left, path, false) || searchLoop(up, path, true) || searchLoop(upLeft, path, false);
    }
}
