package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.Coordinate;
import ar.fiuba.tdd.grupo04.Input;
import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.rule.CellGroup;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
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
        valuedAmount = (rowSize / 2) * (columnSize / 2);
        board = new Board(rowSize, columnSize);
        for (int i = 0; i < rowSize / 2; i++) {
            for (int j = 0; j < columnSize / 2; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Input input = new Input(coordinate, VALUE);
                board.fill(input);
            }
        }
        List<Integer> values = new ArrayList<>();
        values.add(VALUE);
        collector = new ValuedCollector(values);
    }

    @Test
    public void testCollect_1() {
        assertEquals(1, collector.collect(board).size());
    }

    @Test
    public void testCollect_2() {
        List<CellGroup> groups = collector.collect(board);
        for (CellGroup group : groups) {
            assertEquals(valuedAmount, group.getCells().size());
        }
    }

}
