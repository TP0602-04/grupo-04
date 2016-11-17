package ar.fiuba.tdd.grupo04;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class CoordinateTests {
    private static Random random;

    @BeforeClass
    public static void init() {
        random = new Random();
    }

    @Test
    public void testGetRow() {
        int row = random.nextInt();
        Coordinate coordinate = new Coordinate(row, random.nextInt());
        assertEquals(coordinate.row(), row);
    }

    @Test
    public void testGetColumn() {
        int column = random.nextInt();
        Coordinate coordinate = new Coordinate(random.nextInt(), column);
        assertEquals(coordinate.column(), column);
    }

    @Test
    public void testEquals_1() {
        int row = random.nextInt();
        int column = random.nextInt();
        Coordinate coord1 = new Coordinate(row, column);
        Coordinate coord2 = new Coordinate(row, column);
        assertTrue(coord1.equals(coord2));
    }

    @Test
    public void testEquals_2() {
        Coordinate coord1 = new Coordinate(2, 1);
        Coordinate coord2 = new Coordinate(3, 4);
        assertFalse(coord1.equals(coord2));
    }
}
