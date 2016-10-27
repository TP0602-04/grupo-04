package ar.fiuba.tdd.grupo04.rule.condition;

import java.util.HashMap;
import java.util.Map;

public class ConditionFactory {
    private interface ConditionCreator {
        ICondition execute();
    }

    private static Map<String, ConditionCreator> map;

    static {
        map = new HashMap<String, ConditionCreator>();
        map.put("AllFilledCondition", AllFilledCondition::new);
        map.put("AllGreaterThanCondition", AllGreaterThanCondition::new);
        map.put("AllLesserThanCondition", AllLesserThanCondition::new);
        map.put("MultiplyCondition", MultiplyCondition::new);
        map.put("SumCondition", SumCondition::new);
        map.put("UniqueCondition", UniqueCondition::new);
    }

    public static ICondition create(String type) throws Exception {
        if (!map.containsKey(type)) {
            throw new Exception("Unknown Condition");//TODO: Use custom exception
        }
        return map.get(type).execute();
    }
}
