package ar.fiuba.tdd.pgotuzzo;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CellTests {
    private static Random random;

    private Coordinate coordinate;
    private Cell cell;

    @BeforeClass
    public static void initClass() {
        random = new Random();
    }

    @Before
    public void initTest() {
        coordinate = new Coordinate(
                random.nextInt(),
                random.nextInt()
        );
        cell = new Cell(coordinate);
    }

    @Test
    public void testDefaultState_1() {
        assertNull(cell.getValue());
    }

    @Test
    public void testDefaultState_2() {
        assertEquals(true, cell.isEditable());
    }

    @Test
    public void testGetValue() {
        Integer value = random.nextInt();
        Cell cell = new Cell(coordinate, value);
        assertEquals(value, cell.getValue());
    }

    @Test
    public void testSetValue_1() {
        Integer value = random.nextInt();
        cell.setValue(value);
        assertEquals(value, cell.getValue());
    }

    @Test
    public void testSetValue_2() {
        Integer value = random.nextInt();
        cell.setValue(1);
        cell.setValue(2);
        cell.setValue(3);
        cell.setValue(value);
        assertEquals(value, cell.getValue());
    }

    @Test
    public void testGetCoordinate() {
        assertEquals(coordinate, cell.getCoordinate());
    }

    @Test
    public void testSetEditable() {
        cell.edit(false);
        assertEquals(false, cell.isEditable());
    }

    @Test
    public void testCellNotEditable() {
        final Integer initValue = 10;
        final Integer newValue = 5;
        Cell cell = new Cell(coordinate, 10);
        cell.edit(false);
        cell.setValue(newValue);
        assertEquals(initValue, cell.getValue());
    }

}
