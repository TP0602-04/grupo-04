package ar.fiuba.tdd.grupo04.board;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTests {
    private IBoard<Integer> board3x3;

    @Before
    public void init() {
        board3x3 = new Board<>(3, 3);
        board3x3.put(0, new Coordinate(0, 0));
        board3x3.put(1, new Coordinate(0, 1));
        board3x3.put(2, new Coordinate(0, 2));
        board3x3.put(3, new Coordinate(1, 0));
        board3x3.put(4, new Coordinate(1, 1));
        board3x3.put(5, new Coordinate(1, 2));
        board3x3.put(6, new Coordinate(2, 0));
        board3x3.blockCell(new Coordinate(2, 1));
        board3x3.put(8, new Coordinate(2, 2));
    }

    @Test
    public void testGetCorrectValueFromCoordinate() {
        assertEquals(board3x3.get(new Coordinate(1, 2)).getValue().get(), (Integer)5);
    }

    @Test
    public void testGetCorrectColumnLength() {
        assertEquals(board3x3.columnsLength(), (Integer)3);
    }

    @Test
    public void testGetCorrectRowLength() {
        assertEquals(board3x3.rowsLength(), (Integer)3);
    }

    @Test
    public void testGetBlockedCell() {
        assertTrue(board3x3.get(new Coordinate(2, 1)).isBlocked());
    }

    @Test
    public void testGetCellInDefaultValuedBoard() {
        IBoard<Integer> board2x2 = new Board<>(2, 2, 3);
        assertEquals(board2x2.get(new Coordinate(0, 1)).getValue().get(), (Integer)3);
    }

}
