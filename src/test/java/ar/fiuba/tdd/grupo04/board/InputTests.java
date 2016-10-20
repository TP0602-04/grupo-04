package ar.fiuba.tdd.grupo04.board;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputTests {

    @Test
    public void testGetValue() {
        Integer col = 10;
        Integer row = 5;
        Integer value = 2;
        Coordinate newCoordinate = new Coordinate(row,col);
        Input<Integer> in = new Input<Integer>(Optional.of(value) , newCoordinate);
        assertEquals(in.getValue().get(),value);
    }

    @Test
    public void testGetCoordinate() {
        Integer col = 10;
        Integer row = 5;
        Integer value = 2;
        Coordinate newCoordinate = new Coordinate(row,col);
        Coordinate newCoordinate2 = new Coordinate(row,col);
        Input<Integer> in = new Input<Integer>(Optional.of(value) , newCoordinate);
        assertTrue(in.getCoordinate().equals(newCoordinate2));
    }

    @Test
    public void testisNotBlocked() {
        Integer col = 10;
        Integer row = 5;
        Integer value = 2;
        Coordinate newCoordinate = new Coordinate(row,col);
        Input<Integer> in = new Input<Integer>(Optional.of(value) , newCoordinate);
        assertFalse(in.isBlocked());
    }

}
