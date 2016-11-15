package ar.fiuba.tdd.grupo04.json.parser;

import ar.fiuba.tdd.grupo04.model.board.IBoard;
import ar.fiuba.tdd.grupo04.model.rule.condition.ICondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.factory.ConditionFactory;

import java.util.ArrayList;
import java.util.List;

public class ConditionJsonParser {

    public static List<ICondition> parse(List<String> conditionTypes, IBoard board) throws Exception {
        List<ICondition> conditions = new ArrayList<>();
        for (String type : conditionTypes) {
            conditions.add(ConditionFactory.create(type,board));
        }
        return conditions;
    }
}
