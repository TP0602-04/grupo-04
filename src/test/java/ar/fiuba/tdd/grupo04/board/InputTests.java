package ar.fiuba.tdd.grupo04.board;

import org.junit.Test;
import org.junit.Before;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputTests {

    Coordinate coordinateR5C10;

    @Before
    public void init() {
        coordinateR5C10 = new Coordinate(5,10);
    }

    @Test
    public void testGetValue() {
        Input<Integer> in = new Input<Integer>(Optional.of(2) , coordinateR5C10);
        assertEquals(in.getValue().get(),(Integer)2);
    }

    @Test
    public void testGetCoordinate() {
        Input<Integer> in = new Input<Integer>(Optional.of(5) , coordinateR5C10);
        assertTrue(in.getCoordinate().equals(new Coordinate(5, 10)));
    }

    @Test
    public void testisNotBlocked() {
        Input<Integer> in = new Input<Integer>(Optional.of(1) , coordinateR5C10);
        assertFalse(in.isBlocked());
    }

}
