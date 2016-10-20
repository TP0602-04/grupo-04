package ar.fiuba.tdd.grupo04.board;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BlockedInputTests {

    Coordinate coordinateR5C10;

    @Before
    public void init() {
        coordinateR5C10 = new Coordinate(5,10);
    }

    @Test
    public void testGetCoordinate() {

        BlockedInput in = new BlockedInput(coordinateR5C10);
        assertTrue(in.getCoordinate().equals(new Coordinate(5, 10)));
    }

    @Test
    public void testIsBlocked() {
        BlockedInput in = new BlockedInput(coordinateR5C10);
        assertTrue(in.isBlocked());
    }

    @Test(expected = SecurityException.class)
    public void testGetValueThrowsException() {
        BlockedInput in = new BlockedInput(coordinateR5C10);
        in.getValue();
    }

}
