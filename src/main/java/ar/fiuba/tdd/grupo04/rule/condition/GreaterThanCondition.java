package ar.fiuba.tdd.grupo04.rule.condition;

public class GreaterThanCondition extends CompareCondition {

    public GreaterThanCondition(int min) {
        super(Comparator.GREATER, min);
    }

    @Override
    protected String getConditionName() {
        return GreaterThanCondition.class.getSimpleName();
    }

}
