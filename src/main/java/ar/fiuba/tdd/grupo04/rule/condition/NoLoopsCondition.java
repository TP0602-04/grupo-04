package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("CPD-START")
public class NoLoopsCondition<R extends IInputGroup<Boolean>> implements ICondition<R> {
    private List<IInput<Boolean>> inputs;

    @Override
    public boolean check(R inputGroup) {
        inputs = inputGroup.getInputs().stream().filter(i -> i.getValue().isPresent()).filter(i -> (i.getCoordinate()
                .row() & 1) != 0 && (i.getCoordinate().column() & 1) != 0).collect(Collectors.toList());

        while (!inputs.isEmpty()) {
            final IInput<Boolean> input = inputs.get(0);
            if (hasLoop(input)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasLoop(IInput<Boolean> initialPosition) {
        return searchLoop(Optional.of(initialPosition), new ArrayList<>(), true);
    }

    private boolean searchLoop(Optional<IInput<Boolean>> actualPosition, List<IInput<Boolean>> path, boolean comesFromLeft) {
        if (!actualPosition.isPresent()) {
            return false;
        } else if (path.contains(actualPosition.get())) {
            return true;
        }

        final IInput<Boolean> position = actualPosition.get();
        path.add(position);
        inputs.remove(position);

        final Boolean actualDirection = position.getValue().get();
        final Optional<IInput<Boolean>> up =
                inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(-2,0)))
                        && !actualDirection.equals(i.getValue().get())).findFirst();

        final Optional<IInput<Boolean>> down =
                inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(2,0)))
                        && !actualDirection.equals(i.getValue().get())).findFirst();

        if (comesFromLeft) {
            final Optional<IInput<Boolean>> right =
                    inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(0,2)))
                            && !actualDirection.equals(i.getValue().get())).findFirst();
            //la diagonal va de abajo a la izquierda a arriba a la derecha
            if (actualDirection) {
                final Optional<IInput<Boolean>> upRight =
                        inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(-2,2)))
                                && !actualDirection.equals(i.getValue().get())).findFirst();
                return searchLoop(right, path, true) || searchLoop(up, path, false) || searchLoop(upRight, path, true);
            } else {
                final Optional<IInput<Boolean>> downRight =
                        inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(2,2)))
                                && !actualDirection.equals(i.getValue().get())).findFirst();
                return searchLoop(right, path, true) || searchLoop(down, path, false) || searchLoop(downRight, path, true);
            }
        }
        final Optional<IInput<Boolean>> left =
                inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(0,-2)))
                        && !actualDirection.equals(i.getValue().get())).findFirst();
        //la diagonal va de abajo a la izquierda a arriba a la derecha
        if (actualDirection) {
            final Optional<IInput<Boolean>> downLeft =
                    inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(2,-2)))
                            && !actualDirection.equals(i.getValue().get())).findFirst();
            return searchLoop(left, path, false) || searchLoop(down, path, true) || searchLoop(downLeft, path, false);
        }
        final Optional<IInput<Boolean>> upLeft =
                inputs.stream().filter(i -> i.getCoordinate().equals(position.getCoordinate().plus(new Coordinate(-2,-2)))
                        && !actualDirection.equals(i.getValue().get())).findFirst();
        return searchLoop(left, path, false) || searchLoop(up, path, true) || searchLoop(upLeft, path, false);
    }
}
