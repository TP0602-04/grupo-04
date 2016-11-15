package ar.fiuba.tdd.grupo04.model.rule.condition.factory;

import ar.fiuba.tdd.grupo04.model.rule.condition.*;

import java.util.HashMap;
import java.util.Map;

public class ConditionFactory {
    private static Map<String, ConditionCreator> map;

    static {
        map = new HashMap<String, ConditionCreator>();
        map.put("AllFilledCondition", AllFilledCondition::new);
        map.put("AllGreaterThanCondition", AllGreaterThanCondition::new);
        map.put("AllLesserThanCondition", AllLesserThanCondition::new);
        map.put("AllMarkedContiguousCondition", AllMarkedContiguousCondition::new);
        map.put("MultiplyCondition", MultiplyCondition::new);
        map.put("SumCondition", SumCondition::new);
        map.put("UniqueCondition", UniqueCondition::new);
        map.put("CountEdgesBiggerCondition", CountEdgesBiggerCondition::new);
        map.put("CountEdgesEqualCondition", CountEdgesEqualCondition::new);
        map.put("CountNodesBiggerCondition", CountNodesBiggerCondition::new);
        map.put("CountNodesEqualCondition", CountNodesEqualCondition::new);
        map.put("OneLoopCondition", OneLoopCondition::new);
    }

    public static ICondition create(String type) throws Exception {
        if (!map.containsKey(type)) {
            throw new Exception("Unknown Condition");//TODO: Use custom exception
        }
        return map.get(type).execute();
    }

    private interface ConditionCreator {
        ICondition execute();
    }
}
