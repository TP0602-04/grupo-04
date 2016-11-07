package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.IBoard;

import java.util.List;

public interface ICollector<T> {

    List<T> collect(IBoard board);

}
