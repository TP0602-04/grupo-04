package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Board;

import java.util.List;

public class AllFillableCollector<T> implements ICollector {
    private AllCollector<T> allCollector;

    public AllFillableCollector(Board<T> board, Integer value) {
        allCollector = new AllCollector<T>(board, value);
    }

    @Override
    public List getInputGroups() {
        //filter blocked cells;
        return allCollector.getInputGroups();
    }
}
