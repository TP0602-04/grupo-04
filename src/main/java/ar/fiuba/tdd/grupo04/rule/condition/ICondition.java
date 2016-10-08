package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.rule.IInputGroup;

public interface ICondition<R extends IInputGroup> {
    boolean check(R inputGroup);
}
