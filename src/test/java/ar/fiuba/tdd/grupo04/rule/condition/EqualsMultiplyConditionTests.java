package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.generator.CellGenerator;
import ar.fiuba.tdd.grupo04.generator.IntGenerator;
import ar.fiuba.tdd.grupo04.rule.ReferencedCellGroup;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class EqualsMultiplyConditionTests {
    private static final int MAX_GROUP_SIZE = 10;
    private static final int MAX_CELL_VALUE = 10;

    private ReferencedCellGroup matchGroup;
    private EqualsMultiplyCondition condition;

    @Before
    public void initTest() {
        int size = IntGenerator.getInt(1, MAX_GROUP_SIZE);
        int defaultValue = IntGenerator.getInt(1, MAX_CELL_VALUE);
        List<Cell> cells = CellGenerator.getCellListWithDefaultValue(size, defaultValue);
        int multiplyResult = (int) Math.pow(defaultValue, size);
        List<Integer> referenceValues = new ArrayList<>();
        referenceValues.add(multiplyResult);
        matchGroup = new ReferencedCellGroup(cells, referenceValues);

        condition = new EqualsMultiplyCondition();
    }

    @Test
    public void testCheckPassed_1() {
        assertTrue(condition.check(matchGroup));
    }

    @Test
    public void testCheckPassed_2() {
        List<Cell> cells = matchGroup.getCells();
        List<Integer> referenceValues = matchGroup.getReferencedValues();
        // add an empty cell
        Cell emptyCell = CellGenerator.getEmptyCell();
        cells.add(emptyCell);
        ReferencedCellGroup groupWithEmptyCells = new ReferencedCellGroup(cells, referenceValues);
        assertTrue(condition.check(groupWithEmptyCells));
    }


}
