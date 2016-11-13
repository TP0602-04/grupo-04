package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.inputs.BooleanInput;
import ar.fiuba.tdd.grupo04.model.inputs.IInput;
import ar.fiuba.tdd.grupo04.model.rule.IInputGroup;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoContiguousMarkedComparatorCondition<R extends IInputGroup<BooleanInput>> implements ICondition<R> {
    private List<BooleanInput> markedInputs;
    private final BiFunction<Long, Long, Boolean> comparator;
    private static final long VALUE = 1;

    public TwoContiguousMarkedComparatorCondition(BiFunction<Long, Long, Boolean> comparator) {
        this.comparator = comparator;
    }

    @Override
    public boolean check(R inputGroup) {
        markedInputs = inputGroup.getInputs().stream().filter(IInput::isFilled).filter(BooleanInput::getState).collect(Collectors.toList());
        final Stream<Long> longStream = inputGroup.getInputs().stream().filter(IInput::isFilled).filter(BooleanInput::getState).map(i -> markedAround(i.getCoordinate()));
        return longStream.allMatch(i-> comparator.apply(VALUE, i));
    }

    private long markedAround(Coordinate coordinate) {
        return markedInputs.stream().map(IInput::getCoordinate).filter(coordinate::isAround).count();
    }
}
