package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.inputs.BooleanInput;
import ar.fiuba.tdd.grupo04.model.inputs.IInput;
import ar.fiuba.tdd.grupo04.model.rule.IInputGroup;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class TwoContiguousMarkedComparatorCondition<R extends IInputGroup<BooleanInput>> implements ICondition<R> {
    private List<BooleanInput> markedInputs;
    private final BiFunction<Long, Long, Boolean> comparator;
    private static final long VALUE = 2;

    public TwoContiguousMarkedComparatorCondition(BiFunction<Long, Long, Boolean> comparator) {
        this.comparator = comparator;
    }

    @Override
    public boolean check(R inputGroup) {
        markedInputs = inputGroup.getInputs().stream().filter(IInput::isFilled).filter(BooleanInput::getState).collect(Collectors.toList());
        return inputGroup.getInputs().stream().filter(IInput::isFilled).filter(BooleanInput::getState).allMatch(i-> comparator.apply(markedAround(i.getCoordinate()), VALUE));
    }

    private long markedAround(Coordinate coordinate) {
        return markedInputs.stream().map(IInput::getCoordinate).filter(coordinate::isAround).count();
    }
}
