package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.games.ValuedCoordinate;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmptyContiguousInGroupCondition<S, R extends IInputGroup<S>> implements ICondition<R> {
    private final Function<S, Boolean> isMarked;
    private final Function<S, Boolean> isNode;
    private final IBoard<S> board;

    public EmptyContiguousInGroupCondition(Function<S, Boolean> isMarked, Function<S, Boolean> isNode, IBoard board) {
        this.isMarked = isMarked;
        this.isNode = isNode;
        this.board = board;
    }

    @Override
    public boolean check(R inputGroup) {
        final List<? extends IInput<S>> inputs = inputGroup.getInputs();
        final List<Coordinate> coordinatesInGroup = inputGroup.getInputs().stream().map(IInput::getCoordinate).collect(Collectors.toList());
         return inputs.stream().filter(i -> i.getValue().isPresent()).filter(i -> !isNode.apply(i.getValue().get())).filter(i -> !isMarked.apply(i.getValue().get())).allMatch(i -> contiguousMarkedOrInGroup(i, coordinatesInGroup));
    }

    private boolean contiguousMarkedOrInGroup(IInput<S> input, List<Coordinate> coordinatesInGroup) {
        final Coordinate coordinates = input.getCoordinate();
        final Coordinate up = new Coordinate(coordinates.row(), coordinates.column());
        final Coordinate down = new Coordinate(coordinates.row(), coordinates.column());
        final Coordinate left = new Coordinate(coordinates.row(), coordinates.column());
        final Coordinate right = new Coordinate(coordinates.row(), coordinates.column());

        final boolean upOk = coordinatesInGroup.contains(up) || isMarked.apply(board.get(up).getValue().get());
        final boolean downOk = coordinatesInGroup.contains(down) || isMarked.apply(board.get(down).getValue().get());
        final boolean leftOk = coordinatesInGroup.contains(left) || isMarked.apply(board.get(left).getValue().get());
        final boolean rightOk = coordinatesInGroup.contains(right) || isMarked.apply(board.get(right).getValue().get());

        return upOk && downOk && leftOk && rightOk;
    }
}
