package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.rule.InputGroup;

import java.util.ArrayList;
import java.util.List;

public class BlocksCollector<T> implements ICollector {
    private Board<T> board;
    private final Integer width;
    private final Integer height;

    public BlocksCollector(Board<T> board, Integer width, Integer height) {
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

