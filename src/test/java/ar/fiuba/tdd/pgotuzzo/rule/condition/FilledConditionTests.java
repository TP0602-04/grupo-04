package ar.fiuba.tdd.pgotuzzo.rule.condition;

import ar.fiuba.tdd.pgotuzzo.board.Cell;
import ar.fiuba.tdd.pgotuzzo.generator.CellGenerator;
import ar.fiuba.tdd.pgotuzzo.generator.IntGenerator;
import ar.fiuba.tdd.pgotuzzo.rule.CellGroup;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class FilledConditionTests {
    private static final int MAX_GROUP_SIZE = 100;

    private CellGroup group;
    private CellGroup groupWithEmptyCells;
    private FilledCondition condition;

    @Before
    public void initTest() {
        int size = IntGenerator.getInt(1, MAX_GROUP_SIZE);
        // Random cell group without empty cells
        group = new CellGroup(CellGenerator.getCellList(size));
        // Random cell group with empty cell
        List<Cell> cells = CellGenerator.getCellList(size);
        Cell emptyCell = CellGenerator.getEmptyCell();
        cells.add(emptyCell);
        groupWithEmptyCells = new CellGroup(cells);

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
