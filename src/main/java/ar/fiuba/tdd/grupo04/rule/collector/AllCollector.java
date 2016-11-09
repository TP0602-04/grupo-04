package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.inputs.IInput;
import ar.fiuba.tdd.grupo04.rule.ValuedInputGroup;

import java.util.ArrayList;
import java.util.List;

public class AllCollector implements ICollector {
    private final IBoard board;
    private final Integer value;

    public AllCollector(IBoard board, Integer value) {
        this.board = board;
        this.value = value;
    }


    public AllCollector(IBoard board) {
        this.board = board;
        this.value = 0;
    }

    @Override
    public List<ValuedInputGroup<? extends IInput, Integer>> getInputGroups() {
        Integer rowLength = board.rowsLength();
        Integer colLength = board.columnsLength();
        List<ValuedInputGroup<? extends IInput, Integer>> valuedInputGroups = new ArrayList<>();
        List<IInput> inputs = new ArrayList<>();
        for (Integer i = 0; i < colLength; i++) {
            for (Integer j = 0; j < rowLength; j++) {
                inputs.add(board.get(new Coordinate(j, i)));
            }
        }
        valuedInputGroups.add(new ValuedInputGroup<>(value, inputs));
        return valuedInputGroups;
    }
}
