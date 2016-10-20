package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.board.Input;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;
import ar.fiuba.tdd.grupo04.rule.InputGroup;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AllFilledConditionTests {
    private AllFilledCondition allFilledCondition;
    private List<IInput<Integer>> inputs;

    @Before
    public void init() {
        allFilledCondition = new AllFilledCondition();
        inputs = new ArrayList<>();
        inputs.add(new Input<>(Optional.of(1), new Coordinate(0, 0)));
        inputs.add(new Input<>(Optional.of(2), new Coordinate(0, 0)));
        inputs.add(new Input<>(Optional.of(3), new Coordinate(0, 0)));
    }

    @Test
    public void testCheckTrue() {
        IInputGroup<Integer> inputGroup = new InputGroup<>(inputs);
        assertTrue(allFilledCondition.check(inputGroup));
    }

    @Test
    public void testCheckFalse() {
        inputs.add(new Input<>(Optional.empty(), new Coordinate(0, 0)));
        IInputGroup inputGroup = new InputGroup<>(inputs);
        assertFalse(allFilledCondition.check(inputGroup));
    }
}

