package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.rule.InputGroup;

import java.util.ArrayList;
import java.util.List;

public class ColumnsCollector<T> implements ICollector {
    private Board<T> board;

    public ColumnsCollector(Board<T> board) {
        this.board = board;
    }

    @Override
    public List getInputGroups() {
        Integer rowLength = board.rowsLength();
        Integer colLength = board.columnsLength();
        List<InputGroup> inputGroups = new ArrayList<>();
        for (Integer i = 0; i < colLength; i++) {
            List inputs = new ArrayList<>();
            for (Integer j = 0; j < rowLength; j++) {
                inputs.add(board.get(new Coordinate(j, i)));
            }
            inputGroups.add(new InputGroup(inputs));
        }
        return inputGroups;
    }
}
