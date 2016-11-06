package ar.fiuba.tdd.pgotuzzo.rule.condition;

public interface ICondition<T> {
    boolean check(T predicate);
}
