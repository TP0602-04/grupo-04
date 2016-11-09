package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.inputs.DiagonalInput;
import ar.fiuba.tdd.grupo04.inputs.ValuedCoordinate;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;

import java.util.function.BiFunction;
import java.util.stream.Stream;

@SuppressWarnings("CPD-START")
public class CountDiagonalCondition<R extends IValuedInputGroup<DiagonalInput, ValuedCoordinate>> implements ICondition<R> {
    private final BiFunction<Integer, Integer, Boolean> comparator;

    public CountDiagonalCondition(BiFunction<Integer, Integer, Boolean> comparator) {
        this.comparator = comparator;
    }


    @Override
    public boolean check(R valuedInputGroup) {
        final Stream<? extends DiagonalInput> stream = valuedInputGroup.getInputs().stream();
        final ValuedCoordinate valuedCoordinate = valuedInputGroup.getValue();
        final long countedInputs = stream.filter(DiagonalInput::isFilled).filter(DiagonalInput::isDiagonal).filter(i ->
                i.isDownLeftToUpRight().equals(countableValue(valuedCoordinate, i.getCoordinate()))).count();
        return comparator.apply(valuedCoordinate.getValue(), (int) countedInputs);
    }

    // Dice si tiene si la diagonal tiene que ir de abajo a la izquierda a arriba a la derecha o viceversa segun
    // las coordenadas
    private Boolean countableValue(ValuedCoordinate valuedCoordinate, Coordinate coordinate) {
        final Coordinate difference = valuedCoordinate.getCoordinate().minus(coordinate);
        final int kindOfDiagonal = difference.column() + difference.row();
        // Si la diagonal va de abajo a la izquierda a arriba a la derecha la suma de las coordenadas
        // de la diferencia da cero
        return kindOfDiagonal == 0;
    }

    ;
}
