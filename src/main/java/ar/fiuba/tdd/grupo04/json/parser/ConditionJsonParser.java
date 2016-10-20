package ar.fiuba.tdd.grupo04.json.parser;

import ar.fiuba.tdd.grupo04.rule.condition.*;

public class ConditionJsonParser {

    public static ICondition parse(String conditionType) {
        ICondition condition;
        switch (conditionType) {
            case "UniqueCondition":
                condition = new UniqueCondition();
                break;
            case "AllLesserThanCondition":
                condition = new AllLesserThanCondition();
                break;
            case "AllGreaterThanCondition":
                condition = new AllGreaterThanCondition();
                break;
            case "AllFilledCondition":
                condition = new AllFilledCondition();
                break;
            default:
                condition = null;
                break;
        }
        return condition;
    }
}
