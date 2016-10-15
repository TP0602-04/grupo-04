package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Board;

import java.util.List;

@SuppressWarnings("CPD-START")
public class ColumnsCollector<T> implements ICollector {
    private BlocksCollector<T> blocksCollector;

    public ColumnsCollector(Board<T> board) {
        blocksCollector = new BlocksCollector<T>(board, 1, board.columnsLength());
    }

    @Override
    public List getInputGroups() {
        return blocksCollector.getInputGroups();
    }
}
