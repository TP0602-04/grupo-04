package ar.fiuba.tdd.grupo04.rule.condition.factory;

import ar.fiuba.tdd.grupo04.rule.condition.AllFilledCondition;
import ar.fiuba.tdd.grupo04.rule.condition.AllGreaterThanCondition;
import ar.fiuba.tdd.grupo04.rule.condition.AllLesserThanCondition;
import ar.fiuba.tdd.grupo04.rule.condition.ICondition;
import ar.fiuba.tdd.grupo04.rule.condition.MultiplyCondition;
import ar.fiuba.tdd.grupo04.rule.condition.SumCondition;
import ar.fiuba.tdd.grupo04.rule.condition.UniqueCondition;

import java.util.HashMap;
import java.util.Map;

public class ConditionFactory {
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

    private interface ConditionCreator {
        ICondition execute();
    }
}
