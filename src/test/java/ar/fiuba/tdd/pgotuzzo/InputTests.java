package ar.fiuba.tdd.pgotuzzo;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class InputTests {
    private static Random random;

    private Coordinate coordinate;
    private int value;
    private Input input;

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
        value = random.nextInt();
        input = new Input(coordinate, value);
    }

    @Test
    public void testGetValue() {
        assertEquals(value, input.getValue());
    }

    @Test
    public void testGetCoordinate() {
        assertEquals(coordinate, input.getCoordinate());
    }

}
