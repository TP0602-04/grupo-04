package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.board.IBoard;
import ar.fiuba.tdd.grupo04.model.inputs.GraphInput;
import ar.fiuba.tdd.grupo04.model.inputs.IInput;
import ar.fiuba.tdd.grupo04.model.rule.IValuedInputGroup;

import java.util.List;
import java.util.stream.Collectors;

public class EmptyContiguousInGroupCondition<R extends IValuedInputGroup<GraphInput, Integer>> implements ICondition<R> {
    private final IBoard board;

    public EmptyContiguousInGroupCondition(IBoard board) {
        this.board = board;
    }

    @Override
    public boolean check(R inputGroup) {
        final List<? extends GraphInput> inputs = inputGroup.getInputs();
        final List<Coordinate> coordinatesInGroup = inputGroup.getInputs().stream().map(IInput::getCoordinate).collect(Collectors.toList());
        return inputs.stream().filter(GraphInput::isFilled).filter(GraphInput::isMarked).allMatch(i -> contiguousMarkedOrInGroup(i, coordinatesInGroup));
    }

    private boolean contiguousMarkedOrInGroup(GraphInput input, List<Coordinate> coordinatesInGroup) {
        final Coordinate coordinates = input.getCoordinate();
        final Coordinate up = new Coordinate(coordinates.row(), coordinates.column());
        final Coordinate down = new Coordinate(coordinates.row(), coordinates.column());
        final Coordinate left = new Coordinate(coordinates.row(), coordinates.column());
        final Coordinate right = new Coordinate(coordinates.row(), coordinates.column());

        final boolean upOk = coordinatesInGroup.contains(up) || ((GraphInput)board.get(up)).isMarked();
        final boolean downOk = coordinatesInGroup.contains(down) || ((GraphInput)board.get(down)).isMarked();
        final boolean leftOk = coordinatesInGroup.contains(left) || ((GraphInput)board.get(left)).isMarked();
        final boolean rightOk = coordinatesInGroup.contains(right) || ((GraphInput)board.get(right)).isMarked();

        return upOk && downOk && leftOk && rightOk;
    }
}