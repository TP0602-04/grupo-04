package ar.fiuba.tdd.pgotuzzo.rule.collector;

import ar.fiuba.tdd.pgotuzzo.Board;
import ar.fiuba.tdd.pgotuzzo.IBoard;
import ar.fiuba.tdd.pgotuzzo.rule.CellGroup;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class RowCollectorTests {
    private static final int MAX_SIZE = 100;
    private static Random random;

    private IBoard board;
    private int rowSize;
    private int columnSize;
    private RowCollector collector;

    @BeforeClass
    public static void initClass() {
        random = new Random();
    }

    @Before
    public void initTest() {
        rowSize = random.nextInt(MAX_SIZE);
        columnSize = random.nextInt(MAX_SIZE);
        board = new Board(rowSize, columnSize);
        collector = new RowCollector();
    }

    @Test
    public void testCollect_1() {
        assertEquals(rowSize, collector.collect(board).size());
    }

    @Test
    public void testCollect_2() {
        List<CellGroup> groups = collector.collect(board);
        for (CellGroup group : groups) {
            assertEquals(columnSize, group.getCells().size());
        }
    }

}
