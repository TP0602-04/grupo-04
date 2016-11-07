package ar.fiuba.tdd.grupo04;

import ar.fiuba.tdd.grupo04.board.Board;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BoardTests {
    private static final int MIN_BOARD_SIZE = 1;
    private static final int MAX_BOARD_SIZE = 100;
    private static Random random;

    private Board board;
    private int columnSize;
    private int rowSize;

    @BeforeClass
    public static void initClass() {
        random = new Random();
    }

    @Before
    public void initTest() {
        columnSize = random.ints(MIN_BOARD_SIZE, MAX_BOARD_SIZE + 1).iterator().nextInt();
        rowSize = random.ints(MIN_BOARD_SIZE, MAX_BOARD_SIZE + 1).iterator().nextInt();
        board = new Board(rowSize, columnSize);
    }

    @Test
    public void testGetColumnSize() {
        assertEquals(columnSize, board.getColumnSize());
    }

    @Test
    public void testGetRowSize() {
        assertEquals(rowSize, board.getRowSize());
    }

    @Test
    public void testGetExistingCell() {
        Coordinate coordinate = new Coordinate(
                random.ints(MIN_BOARD_SIZE, rowSize).iterator().nextInt(),
                random.ints(MIN_BOARD_SIZE, columnSize).iterator().nextInt()
        );
        assertNotNull(board.getCell(coordinate));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNotExistingCell() {
        Coordinate coordinate = new Coordinate(rowSize, columnSize);
        board.getCell(coordinate);
    }

    @Test
    public void testGetCells() {
        assertEquals(columnSize * rowSize, board.getCells().size());
    }

}
