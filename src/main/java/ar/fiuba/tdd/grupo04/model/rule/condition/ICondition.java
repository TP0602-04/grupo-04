package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.rule.IInputGroup;

public interface ICondition<R extends IInputGroup> {
    boolean check(R inputGroup);
}
