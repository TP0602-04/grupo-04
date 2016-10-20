package ar.fiuba.tdd.grupo04.rule;


import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.board.Input;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class InputGroupTests {

    private InputGroup<Integer>  valuedInput;


    @Before
    public void init() {
        Input<Integer> input = new Input<Integer>(Optional.of(2) , new Coordinate(2,2));
        List<IInput<Integer>> inputs = new ArrayList<>();
        inputs.add(input);
        valuedInput = new InputGroup<Integer>(inputs);
    }

    @Test
    public void testGetInputGroups() {
        assertEquals(valuedInput.getInputs().get(0).getValue().get(),(Integer)2);
    }

}
