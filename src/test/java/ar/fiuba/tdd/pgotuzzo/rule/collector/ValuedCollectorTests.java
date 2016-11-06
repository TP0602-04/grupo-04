package ar.fiuba.tdd.pgotuzzo.rule.collector;

import ar.fiuba.tdd.pgotuzzo.Coordinate;
import ar.fiuba.tdd.pgotuzzo.Input;
import ar.fiuba.tdd.pgotuzzo.board.Board;
import ar.fiuba.tdd.pgotuzzo.board.IBoard;
import ar.fiuba.tdd.pgotuzzo.rule.CellGroup;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ValuedCollectorTests {
    private static final int MAX_SIZE = 100;
    private static final int VALUE = 1;
    private static Random random;

    private IBoard board;
    private int rowSize;
    private int columnSize;
    private int valuedAmount;
    private ValuedCollector collector;

    @BeforeClass
    public static void initClass() {
        random = new Random();
    }

    @Before
    public void initTest() {
        rowSize = random.nextInt(MAX_SIZE);
        columnSize = random.nextInt(MAX_SIZE);
        valuedAmount = random.nextInt(MAX_SIZE);
        board = new Board(rowSize, columnSize);
        for (int i = 0; i < valuedAmount; i++) {
            Coordinate coordinate = new Coordinate(
                    random.nextInt(rowSize),
                    random.nextInt(columnSize)
            );
            Input input = new Input(coordinate, VALUE);
            board.fill(input);
        }
        collector = new ValuedCollector(VALUE);
    }

    @Test
    public void testCollect_1() {
        assertEquals(1, collector.collect(board).size());
    }
// FIXME - Continue HERE!!
//    @Test
//    public void testCollect_2() {
//        List<CellGroup> groups = collector.collect(board);
//        for (CellGroup group : groups) {
//            assertEquals(valuedAmount, group.getCells().size());
//        }
//    }

}
