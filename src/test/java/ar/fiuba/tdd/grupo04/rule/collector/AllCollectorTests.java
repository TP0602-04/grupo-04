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

public class AllCollectorTests {
    private static final int MAX_SIZE = 100;
    private static Random random;

    private IBoard board;
    private int rowSize;
    private int columnSize;
    private AllCollector collector;

    @BeforeClass
    public static void initClass() {
        random = new Random();
    }

    @Before
    public void initTest() {
        rowSize = random.nextInt(MAX_SIZE);
        columnSize = random.nextInt(MAX_SIZE);
        board = new Board(rowSize, columnSize);
        collector = new AllCollector();
    }

    @Test
    public void testCollect_1() {
        assertEquals(1, collector.collect(board).size());
    }

    @Test
    public void testCollect_2() {
        List<CellGroup> groups = collector.collect(board);
        for (CellGroup group : groups) {
            assertEquals(columnSize * rowSize, group.getCells().size());
        }
    }

}
