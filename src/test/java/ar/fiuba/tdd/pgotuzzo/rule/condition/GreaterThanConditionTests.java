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

public class GreaterThanConditionTests {
    private static final int MAX_GROUP_SIZE = 1000;

    private static Random random;

    private Cell borderCell;
    private CellGroup group;
    private CellGroup groupWithEmptyCells;
    private GreaterThanCondition condition;

    @BeforeClass
    public static void initClass() {
        random = new Random();
    }

    @Before
    public void initTest() {
        int size = random.ints(1, MAX_GROUP_SIZE).iterator().next();
        int minValue = random.ints(Integer.MIN_VALUE, Integer.MAX_VALUE - 1).iterator().nextInt();
        // init groups
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Coordinate coordinate = new Coordinate(
                    random.nextInt(),
                    random.nextInt()
            );
            int value = random.ints(minValue + 1, Integer.MAX_VALUE).iterator().nextInt();
            Cell cell = new Cell(coordinate, value);
            cells.add(cell);
        }
        group = new CellGroup(cells);
        Cell emptyCell = new Cell(
                new Coordinate(random.nextInt(), random.nextInt())
        );
        cells.add(emptyCell);
        groupWithEmptyCells = new CellGroup(cells);
        // init borer cell
        Coordinate coordinate = new Coordinate(
                random.nextInt(),
                random.nextInt()
        );
        borderCell = new Cell(coordinate, minValue);
        // init condition
        condition = new GreaterThanCondition(minValue);
    }

    @Test
    public void testCheckPassed_1() {
        assertTrue(condition.check(group));
    }

    @Test
    public void testCheckPassed_2() {
        assertTrue(condition.check(groupWithEmptyCells));
    }

    @Test
    public void testCheckFailed_1() {
        List<Cell> cells = group.getCells();
        cells.add(borderCell);
        CellGroup otherGroup = new CellGroup(cells);
        assertFalse(condition.check(otherGroup));
    }

    @Test
    public void testCheckFailed_2() {
        List<Cell> cells = groupWithEmptyCells.getCells();
        cells.add(borderCell);
        CellGroup otherGroup = new CellGroup(cells);
        assertFalse(condition.check(otherGroup));
    }

}
