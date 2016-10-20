package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.board.Input;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;
import ar.fiuba.tdd.grupo04.rule.ValuedInputGroup;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AllGreaterThanConditionTests {
    private ICondition<IValuedInputGroup<Integer, Integer>> allGreaterThanCondition;
    private List<IInput<Integer>> inputs;

    @Before
    public void init() {
        allGreaterThanCondition = new AllGreaterThanCondition<>();
        inputs = new ArrayList<>();
        inputs.add(new Input<>(Optional.of(3), new Coordinate(0, 0)));
        inputs.add(new Input<>(Optional.of(7), new Coordinate(0, 0)));
    }

    @Test
    public void testCheckTrue() {
        IValuedInputGroup<Integer, Integer> valuedInputGroup = new ValuedInputGroup<>(2, inputs);
        assertTrue(allGreaterThanCondition.check(valuedInputGroup));
    }

    @Test
    public void testCheckFalse() {
        IValuedInputGroup<Integer, Integer> valuedInputGroup = new ValuedInputGroup<>(4, inputs);
        assertFalse(allGreaterThanCondition.check(valuedInputGroup));
    }
}
