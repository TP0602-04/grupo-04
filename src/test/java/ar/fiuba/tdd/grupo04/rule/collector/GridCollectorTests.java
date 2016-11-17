package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.rule.CellGroup;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class GridCollectorTests {
    private static final int MAX_SIZE = 100;
    private static Random random;

    private IBoard board;
    private int rowSize;
    private int columnSize;
    private GridCollector columnCollector;
    private GridCollector rowCollector;

    @BeforeClass
    public static void initClass() {
        random = new Random();
    }

    @Before
    public void initTest() {
        rowSize = random.nextInt(MAX_SIZE);
        columnSize = random.nextInt(MAX_SIZE);
        board = new Board(rowSize, columnSize);
        columnCollector = new GridCollector(GridCollector.Filter.COLUMN);
        rowCollector = new GridCollector(GridCollector.Filter.ROW);
    }

    @Test
    public void testColumnCollect_1() {
        assertEquals(columnSize, columnCollector.collect(board).size());
    }

    @Test
    public void testColumnCollect_2() {
        List<CellGroup> groups = columnCollector.collect(board);
        for (CellGroup group : groups) {
            assertEquals(rowSize, group.getCells().size());
        }
    }

    @Test
    public void testRowCollect_1() {
        assertEquals(rowSize, rowCollector.collect(board).size());
    }

    @Test
    public void testRowCollect_2() {
        List<CellGroup> groups = rowCollector.collect(board);
        for (CellGroup group : groups) {
            assertEquals(columnSize, group.getCells().size());
        }
    }

}
