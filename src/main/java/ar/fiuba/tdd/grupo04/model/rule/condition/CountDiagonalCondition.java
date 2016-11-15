package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.inputs.DiagonalInput;
import ar.fiuba.tdd.grupo04.model.inputs.IInput;
import ar.fiuba.tdd.grupo04.model.rule.IValuedInputGroup;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BiFunction;
import java.util.stream.Stream;

@SuppressWarnings("CPD-START")
public class CountDiagonalCondition<R extends IValuedInputGroup<DiagonalInput, Integer>> implements ICondition<R> {
    private final BiFunction<Integer, Integer, Boolean> comparator;

    public CountDiagonalCondition(BiFunction<Integer, Integer, Boolean> comparator) {
        this.comparator = comparator;
    }


    @Override
    public boolean check(R valuedInputGroup) {
        final Stream<? extends DiagonalInput> stream = valuedInputGroup.getInputs().stream();
        final Optional<Coordinate> centerCoordinate = valuedInputGroup.getInputs().stream().filter(DiagonalInput::isCenter).map(IInput::getCoordinate).findFirst();
        if (!centerCoordinate.isPresent()) {
            return false;
        }
        final long countedInputs = stream.filter(DiagonalInput::isFilled).filter(DiagonalInput::isDiagonal).filter(i ->
                i.isDownLeftToUpRight().equals(countableValue(centerCoordinate.get(), i.getCoordinate()))).count();
        return comparator.apply(valuedInputGroup.getValue(), (int) countedInputs);
    }

    // Dice si tiene si la diagonal tiene que ir de abajo a la izquierda a arriba a la derecha o viceversa segun
    // las coordenadas
    private Boolean countableValue(Coordinate centerCoordinate, Coordinate coordinate) {
        final Coordinate difference = centerCoordinate.minus(coordinate);
        final int kindOfDiagonal = difference.column() + difference.row();
        // Si la diagonal va de abajo a la izquierda a arriba a la derecha la suma de las coordenadas
        // de la diferencia da cero
        return kindOfDiagonal == 0;
    }

    ;
}
