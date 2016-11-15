package ar.fiuba.tdd.grupo04.model.rule.condition.factory;

import ar.fiuba.tdd.grupo04.model.rule.condition.AllFilledCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.AllGreaterThanCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.AllLesserThanCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.AtDistanceCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.CountBooleanBiggerCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.CountBooleanEqualCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.CountDiagonalBiggerCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.CountDiagonalEqualCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.CountEdgesBiggerCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.CountEdgesEqualCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.ICondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.MoreThanTwoContiguousMarkedCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.MultiplyCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.NoLoopsCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.OneLoopCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.SumCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.TwoContiguousMarkedCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.UniqueCondition;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("CPD-START")
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
        map.put("CountEdgesBiggerCondition", CountEdgesBiggerCondition::new);
        map.put("CountEdgesEqualCondition", CountEdgesEqualCondition::new);
        map.put("OneLoopCondition", OneLoopCondition::new);
        map.put("MoreThanTwoContiguousMarkedCondition", MoreThanTwoContiguousMarkedCondition::new);
        map.put("TwoContiguousMarkedCondition", TwoContiguousMarkedCondition::new);
        map.put("CountBooleanBiggerCondition", CountBooleanBiggerCondition::new);
        map.put("CountBooleanEqualCondition", CountBooleanEqualCondition::new);
        map.put("CountDiagonalBiggerCondition", CountDiagonalBiggerCondition::new);
        map.put("NoLoopsCondition", NoLoopsCondition::new);
        map.put("CountDiagonalEqualCondition", CountDiagonalEqualCondition::new);
        map.put("AtDistanceCondition", AtDistanceCondition::new);
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
