package ar.fiuba.tdd.pgotuzzo.rule.collector;

import ar.fiuba.tdd.pgotuzzo.IBoard;

import java.util.List;

public interface ICollector<T> {

    List<T> collect(IBoard board);

}
