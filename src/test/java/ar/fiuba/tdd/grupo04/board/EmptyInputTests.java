package ar.fiuba.tdd.grupo04.board;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertTrue;

public class EmptyInputTests {

    Coordinate coordinateR5C10;
    Coordinate coordinateR10C5;

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
    public void testisBlocked() {
        BlockedInput in = new BlockedInput(coordinateR5C10);
        assertTrue(in.isBlocked());
    }

}
