package ar.fiuba.tdd.grupo04.model.rule.collector;

import ar.fiuba.tdd.grupo04.model.rule.IInputGroup;

import java.util.List;

public interface ICollector<R extends IInputGroup> {
    List<R> getInputGroups();
}
