package ar.fiuba.tdd.grupo04.inputs;

import ar.fiuba.tdd.grupo04.board.Coordinate;

import java.util.Optional;

// Esto podria ser algo como SimpleTypeInput<T> y tambien funciona
// pero prometi q sacaba los generics, no lso quiero asustar :P
// borren esto antes de entregarlo ¬¬
public class NumericInput extends IInput {
    private Integer value;

    public NumericInput(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Optional<Integer> getValue() {
        return Optional.ofNullable(value);
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean isFilled() {
        return value != null;
    }
}
