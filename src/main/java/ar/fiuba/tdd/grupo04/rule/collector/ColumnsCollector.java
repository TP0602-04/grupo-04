package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.IBoard;

import java.util.List;

@SuppressWarnings("CPD-START")
public class ColumnsCollector implements ICollector {
    private BlocksCollector blocksCollector;

    public ColumnsCollector(IBoard board) {
        blocksCollector = new BlocksCollector(board, 1, board.columnsLength());
    }

    @Override
    public List getInputGroups() {
        return blocksCollector.getInputGroups();
    }
}
