package ar.fiuba.tdd.grupo04.rule.custom.condition;

public class EqualsMultiplyCondition extends EqualsOpCondition {

    public EqualsMultiplyCondition() {
        super(Operation.MULTIPLY, 1);
    }

    @Override
    protected String getConditionName() {
        return EqualsMultiplyCondition.class.getSimpleName();
    }

}
