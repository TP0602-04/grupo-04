package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.Utils;
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

public class HasOneConditionTests {
    private ICondition<IInputGroup<Boolean>> hasOneCondition;
    private List<IInput<Boolean>> inputs;

    @Before
    public void init() {
        hasOneCondition = new HasOneCondition<>(Utils.isMarkedSegment());
        inputs = new ArrayList<>();
    }

    @Test
    public void testCheckTrue() {
        inputs.add(new Input<>(Optional.of(true), new Coordinate(0, 1)));
        IInputGroup<Boolean> inputGroup = new InputGroup<>(inputs);
        assertTrue(hasOneCondition.check(inputGroup));
    }

    @Test
    public void testCheckFalse() {
        inputs.add(new Input<>(Optional.of(false), new Coordinate(0, 1)));
        IInputGroup<Boolean> inputGroup = new InputGroup<>(inputs);
        assertFalse(hasOneCondition.check(inputGroup));
    }
}
