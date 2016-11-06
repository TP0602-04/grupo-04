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

public class BlockCollectorTests {
    private static final int BASE_SIZE = 20;
    private static final int MAX_MULTIPLIER = 10;
    private static Random random;

    private IBoard board;
    private int blockSize;
    private int blockAmount;
    private BlockCollector collector;

    @BeforeClass
    public static void initClass() {
        random = new Random();
    }

    @Before
    public void initTest() {
        int multiplier = random.ints(1, MAX_MULTIPLIER).iterator().nextInt();
        blockSize = random.ints(1, BASE_SIZE).iterator().nextInt();
        int boardSize = blockSize * multiplier;
        blockAmount = multiplier * multiplier;
        board = new Board(boardSize, boardSize);
        collector = new BlockCollector(blockSize);
    }

    @Test
    public void testCollect_1() {
        assertEquals(blockAmount, collector.collect(board).size());
    }

    @Test
    public void testCollect_2() {
        List<CellGroup> groups = collector.collect(board);
        for (CellGroup group : groups) {
            assertEquals(blockSize * blockSize, group.getCells().size());
        }
    }

}
