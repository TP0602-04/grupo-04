package ar.fiuba.tdd.grupo04.board;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertTrue;

public class EmptyInputTests {

    Coordinate coordinateR5C10;

    @Before
    public void init() {
        coordinateR5C10 = new Coordinate(5,10);
    }

    @Test
    public void testGetCoordinate() {

        EmptyInput in = new EmptyInput(coordinateR5C10);
        assertTrue(in.getCoordinate().equals(new Coordinate(5, 10)));
    }

    @Test
    public void testIsBlocked() {
        EmptyInput in = new EmptyInput(coordinateR5C10);
        assertTrue(in.isBlocked());
    }

    @Test(expected=SecurityException.class)
    public void testGetValueThrowsException() {
        EmptyInput in = new EmptyInput(coordinateR5C10);
        in.getValue();
    }

}
