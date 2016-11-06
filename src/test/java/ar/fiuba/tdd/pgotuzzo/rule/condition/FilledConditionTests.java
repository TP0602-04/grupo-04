package ar.fiuba.tdd.pgotuzzo.rule.condition;

import ar.fiuba.tdd.pgotuzzo.Cell;
import ar.fiuba.tdd.pgotuzzo.Coordinate;
import ar.fiuba.tdd.pgotuzzo.rule.CellGroup;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class FilledConditionTests {
    private static final int MAX_GROUP_SIZE = 1000;

    private static Random random;

    private CellGroup group;
    private CellGroup groupWithEmptyCells;
    private FilledCondition condition;

    @BeforeClass
    public static void initClass() {
        random = new Random();
    }

    @Before
    public void initTest() {
        int size = random.ints(1, MAX_GROUP_SIZE).iterator().next();
        // init groups
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Coordinate coordinate = new Coordinate(
                    random.nextInt(),
                    random.nextInt()
            );
            int value = random.nextInt();
            Cell cell = new Cell(coordinate, value);
            cells.add(cell);
        }
        group = new CellGroup(cells);
        Cell emptyCell = new Cell(
                new Coordinate(random.nextInt(), random.nextInt())
        );
        cells.add(emptyCell);
        groupWithEmptyCells = new CellGroup(cells);
        // init condition
        condition = new FilledCondition();
    }

    @Test
    public void testCheckPassed() {
        assertTrue(condition.check(group));
    }

    @Test
    public void testCheckFailed() {
        assertFalse(condition.check(groupWithEmptyCells));
    }

}
