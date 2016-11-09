package ar.fiuba.tdd.grupo04.json.parser;

import ar.fiuba.tdd.grupo04.rule.condition.factory.ConditionFactory;
import ar.fiuba.tdd.grupo04.rule.condition.ICondition;

import java.util.ArrayList;
import java.util.List;

public class ConditionJsonParser {

    public static List<ICondition> parse(List<String> conditionTypes) throws Exception{
        List<ICondition> conditions = new ArrayList<>();
        for (String type : conditionTypes) {
            conditions.add(ConditionFactory.create(type));
        }
        return conditions;
    }
}
