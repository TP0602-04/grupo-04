package ar.fiuba.tdd.grupo04.rule.custom.condition;

import ar.fiuba.tdd.grupo04.rule.custom.ReferencedCellGroup;

import java.util.List;

public class CountWithinRangeCondition implements ICustomCondition {
    private static final int REF_MIN_IDX = 0;
    private static final int REF_MAX_IDX = 1;

    @Override
    public boolean check(ReferencedCellGroup referencedCellGroup) {
        List<Integer> values = referencedCellGroup.getReferencedValues();
        int min = values.get(REF_MIN_IDX);
        int max = values.get(REF_MAX_IDX);
        long count = referencedCellGroup.getCells().size();
        boolean check = count >= min && count <= max;
        if (!check) {
            System.out.println("============= FAILED =============\n"
                    + "Condition: CountWithinRangeCondition\n"
                    + "Count: " + count + "\n"
                    + "Range: [" + min + ", " + max + "]");
        }
        return check;
    }
}
