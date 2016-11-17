package ar.fiuba.tdd.grupo04.rule.custom.condition;

import ar.fiuba.tdd.grupo04.rule.condition.Condition;
import ar.fiuba.tdd.grupo04.rule.custom.ReferencedCellGroup;

import java.util.List;

public class CountWithinRangeCondition extends Condition implements ICustomCondition {
    private static final int REF_MIN_IDX = 0;
    private static final int REF_MAX_IDX = 1;

    @Override
    protected String getConditionName() {
        return CountWithinRangeCondition.class.getSimpleName();
    }

    @Override
    public boolean check(ReferencedCellGroup referencedCellGroup) {
        List<Integer> values = referencedCellGroup.getReferencedValues();
        int min = values.get(REF_MIN_IDX);
        int max = values.get(REF_MAX_IDX);
        long count = referencedCellGroup.getCells().size();
        boolean check = count >= min && count <= max;
        if (!check) {
            String message = "Count: " + count + "\nRange: [" + min + ", " + max + "]";
            printError(message);
        }
        return check;
    }

}
