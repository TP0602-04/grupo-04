package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Board;

import java.util.List;

@SuppressWarnings("CPD-START")
public class RowsCollector<T> implements ICollector {
    private BlocksCollector<T> blocksCollector;

    public RowsCollector(Board<T> board) {
        blocksCollector = new BlocksCollector<T>(board, 1, board.rowsLength());
    }

    @Override
    public List getInputGroups() {
        return blocksCollector.getInputGroups();
    }
}
