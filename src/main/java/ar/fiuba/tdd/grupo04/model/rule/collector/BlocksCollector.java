package ar.fiuba.tdd.grupo04.model.rule.collector;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.board.IBoard;
import ar.fiuba.tdd.grupo04.model.rule.InputGroup;

import java.util.ArrayList;
import java.util.List;

public class BlocksCollector implements ICollector {
    private final Integer width;
    private final Integer height;
    private IBoard board;

    public BlocksCollector(IBoard board, Integer width, Integer height) {
        this.board = board;
        this.width = width;
        this.height = height;
    }

    private InputGroup getBlock(Integer colOffset, Integer rowOffset) {
        List inputs = new ArrayList<>();
        for (Integer i = 0; i < height; i++) {
            for (Integer j = 0; j < width; j++) {
                inputs.add(board.get(new Coordinate(i + colOffset * height, j + rowOffset * width)));
            }
        }
        return new InputGroup(inputs);
    }

    @Override
    public List getInputGroups() {
        Integer rowLength = board.rowsLength();
        Integer colLength = board.columnsLength();
        List<InputGroup> inputGroups = new ArrayList<>();
        if (rowLength % width == 0 && colLength % height == 0) {
            Integer rowBlocks = rowLength / width;
            Integer colBlocks = colLength / height;
            for (Integer i = 0; i < colBlocks; i++) {
                for (Integer j = 0; j < rowBlocks; j++) {
                    inputGroups.add(getBlock(i, j));
                }
            }
        }
        return inputGroups;
    }
}

