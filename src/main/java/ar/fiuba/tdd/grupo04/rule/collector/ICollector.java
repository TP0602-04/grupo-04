package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.List;

public interface ICollector {
    List<? extends CellGroup> collect(IBoard board);
}
