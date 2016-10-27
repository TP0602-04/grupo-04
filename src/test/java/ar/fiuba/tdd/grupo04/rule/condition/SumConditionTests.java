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

public class SumConditionTests {
    private ICondition<IValuedInputGroup<Integer, Integer>> sumCondition;
    private List<IInput<Integer>> inputs;

    @Before
    public void init() {
        sumCondition = new SumCondition<>();
        inputs = new ArrayList<>();
        inputs.add(new Input<>(2, new Coordinate(0, 0)));
        inputs.add(new Input<>(3, new Coordinate(0, 0)));
    }

    @Test
    public void testCheckTrue() {
        IValuedInputGroup<Integer, Integer> valuedInputGroup = new ValuedInputGroup<>(5, inputs);
        assertTrue(sumCondition.check(valuedInputGroup));
    }

    @Test
    public void testCheckFalse() {
        IValuedInputGroup<Integer, Integer> valuedInputGroup = new ValuedInputGroup<>(6, inputs);
        assertFalse(sumCondition.check(valuedInputGroup));
    }

    @Test
    public void testCheckTrueIfGroupNotComplete() {
        inputs.add(new Input<>(null, new Coordinate(0, 0)));
        IValuedInputGroup<Integer, Integer> valuedInputGroup = new ValuedInputGroup<>(5, inputs);
        assertTrue(sumCondition.check(valuedInputGroup));
    }
}

