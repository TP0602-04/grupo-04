package ar.fiuba.tdd.grupo04.board;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CoordinateTests {

    @Test
    public void testGetColumn() {
        Integer col = 10;
        Integer row = 5;
        Coordinate newCoordinate = new Coordinate(row,col);
        assertEquals(newCoordinate.column(), col);
    }

    @Test
    public void testGetRow() {
        Integer col = 10;
        Integer row = 5;
        Coordinate newCoordinate = new Coordinate(row,col);
        assertEquals(newCoordinate.row(), row);
    }

    @Test
    public void testTwoEqualCordinates() {
        Integer col = 10;
        Integer row = 5;
        Coordinate newCoordinate = new Coordinate(row,col);
        Coordinate newCoordinate2 = new Coordinate(row,col);
        assertTrue(newCoordinate.equals(newCoordinate2));
    }

    @Test
    public void testTwoDiferentCordinates() {
        Integer col = 10;
        Integer row = 5;
        Coordinate newCoordinate = new Coordinate(row,col);
        Coordinate newCoordinate2 = new Coordinate(col,row);
        assertFalse(newCoordinate.equals(newCoordinate2));
    }

}