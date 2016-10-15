package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.rule.InputGroup;
import ar.fiuba.tdd.grupo04.rule.ValuedInputGroup;

import java.util.ArrayList;
import java.util.List;

public class AllCollector<T> implements ICollector {
    private Board<T> board;
    private Integer value;

    public AllCollector(Board<T> board, Integer value) {
        this.board = board;
        this.value = value;
    }

    @Override
    public List getInputGroups() {
        Integer rowLength = board.rowsLength();
        Integer colLength = board.columnsLength();
        List<ValuedInputGroup> valuedInputGroups = new ArrayList<>();
        List inputs = new ArrayList<>();
        for (Integer i = 0; i < colLength; i++) {
            for (Integer j = 0; j < rowLength; j++) {
                inputs.add(board.get(new Coordinate(j, i)));
            }
        }
        valuedInputGroups.add(new ValuedInputGroup(value, inputs));
        return valuedInputGroups;
    }
}
