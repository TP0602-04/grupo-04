package ar.fiuba.tdd.grupo04.board;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CoordinateTests {
    private Coordinate coordinateR5C10;
    private Coordinate coordinateR10C5;

    @Before
    public void init() {
        coordinateR5C10 = new Coordinate(5, 10);
        coordinateR10C5 = new Coordinate(10, 5);
    }

    @Test
    public void testGetColumn() {
        assertEquals(coordinateR5C10.column(), (Integer)10);
    }

    @Test
    public void testGetRow() {
        assertEquals(coordinateR5C10.row(), (Integer)5);
    }

    @Test
    public void testTwoEqualCoordinates() {
        assertTrue(coordinateR5C10.equals(new Coordinate(5, 10)));
    }

    @Test
    public void testTwoDifferentCoordinates() {
        assertFalse(coordinateR5C10.equals(coordinateR10C5));
    }

}
