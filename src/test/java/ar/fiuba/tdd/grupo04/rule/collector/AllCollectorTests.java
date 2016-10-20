package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class AllCollectorTests {
    private AllCollector<Integer> allCollector;
    private Board<Integer> board;

    @Before
    public void init() {
        board = new Board<>(2, 2, 0);
        allCollector = new AllCollector<>(board);
    }

    @Test
    public void testGetInputGroups() {
        List<IInput<Integer>> inputs = allCollector.getInputGroups().get(0).getInputs();
        assertTrue(inputs.contains(board.get(new Coordinate(0, 0))));
        assertTrue(inputs.contains(board.get(new Coordinate(0, 1))));
        assertTrue(inputs.contains(board.get(new Coordinate(1, 0))));
        assertTrue(inputs.contains(board.get(new Coordinate(1, 1))));
    }
}
