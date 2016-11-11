package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.inputs.DiagonalInput;
import ar.fiuba.tdd.grupo04.model.inputs.ValuedCoordinate;
import ar.fiuba.tdd.grupo04.model.rule.IValuedInputGroup;

@SuppressWarnings("CPD-START")
public class CountDiagonalEqualCondition<R extends IValuedInputGroup<DiagonalInput, ValuedCoordinate>> implements ICondition<R> {
    private final CountDiagonalCondition<R> countDiagonalCondition;

    public CountDiagonalEqualCondition() {
        this.countDiagonalCondition = new CountDiagonalCondition<>((expected, counted) -> expected == counted);
    }

    @Override
    public boolean check(R valuedInputGroup) {
        return countDiagonalCondition.check(valuedInputGroup);
    }
}
