package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.inputs.NumericInput;
import ar.fiuba.tdd.grupo04.model.rule.IInputGroup;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AtDistanceCondition<R extends IInputGroup<NumericInput>> implements ICondition<R> {
    private List<NumericInput> inputs;

    @Override
    public boolean check(R inputGroup) {
        inputs = inputGroup.getInputs().stream().filter(NumericInput::isFilled).collect(Collectors.toList());
        return inputs.stream().filter(NumericInput::isFilled).allMatch(this::noneInputCloser);
    }

    private boolean noneInputCloser(NumericInput input) {
        if (!input.getValue().isPresent()) {
            return false;
        }
        final Integer value = input.getValue().get();
        final Coordinate coordinate = input.getCoordinate();
        return !inputs.stream().filter(i -> !coordinate.equals(i.getCoordinate())).filter(i-> value.equals(i.getValue().get())).filter(i-> isCloserThan(coordinate, i.getCoordinate(), value)).findFirst().isPresent();
    }

    private boolean isCloserThan(Coordinate coordinateA, Coordinate coordinateB, Integer distance) {
        int columnDistance = coordinateA.column() - coordinateB.column();
        columnDistance = (columnDistance < 0) ? -columnDistance : columnDistance;
        int rowDistance = coordinateA.row() - coordinateB.row();
        rowDistance = (rowDistance < 0) ? -rowDistance : rowDistance;
        return (columnDistance <= distance && rowDistance == 0) || (rowDistance <= distance && columnDistance == 0);
    }
}
