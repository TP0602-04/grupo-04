package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.rule.IInputGroup;

import java.util.List;

public interface ICollector<R extends IInputGroup> {
    List<R> getInputGroups();
}
