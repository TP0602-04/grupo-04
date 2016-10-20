package ar.fiuba.tdd.grupo04.board;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EmptyInputTests {

    @Test
    public void testGetCoordinate() {
        Integer col = 10;
        Integer row = 5;
        Coordinate newCoordinate = new Coordinate(row,col);
        Coordinate newCoordinate2 = new Coordinate(row,col);
        EmptyInput in = new EmptyInput(newCoordinate);
        assertTrue(in.getCoordinate().equals(newCoordinate2));
    }

    @Test
    public void testisBlocked() {
        Integer col = 10;
        Integer row = 5;
        Coordinate newCoordinate = new Coordinate(row,col);
        EmptyInput in = new EmptyInput(newCoordinate);
        assertTrue(in.isBlocked());
    }

}