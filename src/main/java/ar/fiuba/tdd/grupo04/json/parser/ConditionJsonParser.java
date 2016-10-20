package ar.fiuba.tdd.grupo04.json.parser;

import ar.fiuba.tdd.grupo04.rule.condition.*;

import java.util.ArrayList;
import java.util.List;

public class ConditionJsonParser {

    public static List<ICondition> parse(List<String> conditionTypes) {
        List<ICondition> conditions = new ArrayList<>();
        for (String type : conditionTypes) {
            switch (type) {
                case "UniqueCondition":
                    conditions.add(new UniqueCondition());
                    break;
                case "AllLesserThanCondition":
                    conditions.add(new AllLesserThanCondition());
                    break;
                case "AllGreaterThanCondition":
                    conditions.add(new AllGreaterThanCondition());
                    break;
                case "AllFilledCondition":
                    conditions.add(new AllFilledCondition());
                    break;
                case "MultiplyCondition":
                    conditions.add(new MultiplyCondition());
                    break;
                default:
                    break;
            }
        }
        return conditions;
    }
}
