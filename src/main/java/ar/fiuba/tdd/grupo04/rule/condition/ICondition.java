package ar.fiuba.tdd.grupo04.rule.condition;

public interface ICondition<T> {
    boolean check(T predicate);
}
