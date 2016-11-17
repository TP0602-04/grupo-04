package ar.fiuba.tdd.grupo04.rule.custom.collector;

import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.rule.collector.ICollector;
import ar.fiuba.tdd.grupo04.rule.custom.ReferencedCellGroup;

import java.util.List;

public interface ICustomCollector extends ICollector {
    List<ReferencedCellGroup> collect(IBoard board);
}
