package ar.fiuba.tdd.grupo04.rule.condition;

public class LesserThanCondition extends CompareCondition {

    public LesserThanCondition(int min) {
        super(Comparator.LESSER, min);
    }

    @Override
    protected String getConditionName() {
        return LesserThanCondition.class.getSimpleName();
    }

}
