package ar.fiuba.tdd.grupo04.rule.custom.condition;

public class EqualsSumCondition extends EqualsOpCondition {

    public EqualsSumCondition() {
        super(Operation.SUM, 0);
    }

    @Override
    protected String getConditionName() {
        return EqualsSumCondition.class.getSimpleName();
    }
}
