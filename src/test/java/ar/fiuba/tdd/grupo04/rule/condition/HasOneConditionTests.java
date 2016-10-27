package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.board.Input;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;
import ar.fiuba.tdd.grupo04.rule.InputGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HasOneConditionTests {

    @Mock
    Function<Integer, Boolean> condition;

    @Mock
    Coordinate coordinate;

    @Test
    public void testCheckAllTrue() {
        when(condition.apply(anyInt())).thenReturn(true);

        HasOneCondition<Integer, IInputGroup<Integer>> hasOneCondition = new HasOneCondition<>(condition);
        final List<IInput<Integer>> inputs = Arrays.asList(new Input<>(1, coordinate),
                new Input<>(3, coordinate), new Input<>(2, coordinate));
        IInputGroup<Integer> inputGroup = new InputGroup<>(inputs);

        assertTrue(hasOneCondition.check(inputGroup));
        verify(condition, times(1)).apply(anyInt());
    }

    @Test
    public void testCheckAllFalse() {
        when(condition.apply(anyInt())).thenReturn(false);

        HasOneCondition<Integer, IInputGroup<Integer>> hasOneCondition = new HasOneCondition<>(condition);
        final List<IInput<Integer>> inputs = Arrays.asList(new Input<>(1, coordinate),
                new Input<>(3, coordinate), new Input<>(2, coordinate));
        IInputGroup<Integer> inputGroup = new InputGroup<>(inputs);

        assertFalse(hasOneCondition.check(inputGroup));
        verify(condition, times(3)).apply(anyInt());
    }

    @Test
    public void testCheckOneTrue() {
        when(condition.apply(3)).thenReturn(true);
        when(condition.apply(1)).thenReturn(false);

        HasOneCondition<Integer, IInputGroup<Integer>> hasOneCondition = new HasOneCondition<>(condition);
        final List<IInput<Integer>> inputs = Arrays.asList(new Input<>(1, coordinate),
                new Input<>(3, coordinate), new Input<>(1, coordinate));
        IInputGroup<Integer> inputGroup = new InputGroup<>(inputs);

        assertTrue(hasOneCondition.check(inputGroup));
        //aca no se pueden checkear la cantidad de llamadas pq el stream puede aparecer en cualquier orden
        //solo se sabe q por lo menos llamo una vez al que da true
        verify(condition).apply(3);
    }

    @Test
    public void testCheckOneFalse() {
        when(condition.apply(4)).thenReturn(true);
        when(condition.apply(2)).thenReturn(false);

        HasOneCondition<Integer, IInputGroup<Integer>> hasOneCondition = new HasOneCondition<>(condition);
        final List<IInput<Integer>> inputs = Arrays.asList(new Input<>(4, coordinate),
                new Input<>(4, coordinate), new Input<>(2, coordinate));
        IInputGroup<Integer> inputGroup = new InputGroup<>(inputs);

        assertTrue(hasOneCondition.check(inputGroup));
        //aca no se pueden checkear la cantidad de llamadas pq el stream puede aparecer en cualquier orden
        //solo se sabe q por lo menos llamo una vez al que da true
        verify(condition).apply(4);
    }

    @Test
    public void testCheckFalseWithEmptyOptional() {
        when(condition.apply(anyInt())).thenReturn(false);

        HasOneCondition<Integer, IInputGroup<Integer>> hasOneCondition = new HasOneCondition<>(condition);
        final List<IInput<Integer>> inputs = Arrays.asList(new Input<>(null, coordinate),
                new Input<>(3, coordinate), new Input<>(2, coordinate));
        IInputGroup<Integer> inputGroup = new InputGroup<>(inputs);

        assertFalse(hasOneCondition.check(inputGroup));
        verify(condition, times(2)).apply(anyInt());
    }

    @Test
    public void testCheckTrueWithEmptyOptional() {
        when(condition.apply(anyInt())).thenReturn(true);

        HasOneCondition<Integer, IInputGroup<Integer>> hasOneCondition = new HasOneCondition<>(condition);
        final List<IInput<Integer>> inputs = Arrays.asList(new Input<>(null, coordinate),
                new Input<>(3, coordinate), new Input<>(2, coordinate));
        IInputGroup<Integer> inputGroup = new InputGroup<>(inputs);

        assertTrue(hasOneCondition.check(inputGroup));
        verify(condition, times(1)).apply(anyInt());
    }
}
