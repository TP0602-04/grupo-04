package ar.fiuba.tdd.grupo04.rule;

import ar.fiuba.tdd.grupo04.json.game.CollectorMapper;
import ar.fiuba.tdd.grupo04.json.game.ConditionMapper;
import ar.fiuba.tdd.grupo04.json.game.RuleMapper;
import ar.fiuba.tdd.grupo04.neighborhood.Neighborhood;
import ar.fiuba.tdd.grupo04.rule.collector.*;
import ar.fiuba.tdd.grupo04.rule.condition.*;
import ar.fiuba.tdd.grupo04.rule.custom.CustomRule;
import ar.fiuba.tdd.grupo04.rule.custom.collector.CustomCollector;
import ar.fiuba.tdd.grupo04.rule.custom.collector.CustomValuedCollector;
import ar.fiuba.tdd.grupo04.rule.custom.collector.ICustomCollector;
import ar.fiuba.tdd.grupo04.rule.custom.condition.CountWithinRangeCondition;
import ar.fiuba.tdd.grupo04.rule.custom.condition.EqualsMultiplyCondition;
import ar.fiuba.tdd.grupo04.rule.custom.condition.EqualsSumCondition;
import ar.fiuba.tdd.grupo04.rule.custom.condition.ICustomCondition;

import java.util.List;
import java.util.stream.Collectors;

import static ar.fiuba.tdd.grupo04.json.game.CollectorMapper.*;
import static ar.fiuba.tdd.grupo04.json.game.ConditionMapper.*;

public class RuleFactory {

    public static IRule createRule(Neighborhood neighborhood, RuleMapper ruleMapper) {
        // Create conditions
        List<ConditionMapper> conditionMappers = ruleMapper.getConditions();
        List<ICustomCondition> customConditions = conditionMappers.stream()
                .filter(conditionMapper -> isCustomCondition(conditionMapper.getType()))
                .map(RuleFactory::createCustomCondition)
                .collect(Collectors.toList());
        List<ICondition> conditions = conditionMappers.stream()
                .filter(conditionMapper -> !isCustomCondition(conditionMapper.getType()))
                .map(conditionMapper -> createBaseCondition(neighborhood, conditionMapper))
                .collect(Collectors.toList());

        boolean customCollectorRequired = !customConditions.isEmpty();

        // Create collector
        CollectorMapper collectorMapper = ruleMapper.getCollector();
        String collectorType = collectorMapper.getType();
        List<Integer> collectorParams = collectorMapper.getParams();
        //      Custom
        if (customCollectorRequired && isCustomCollector(collectorType)) {
            ICustomCollector customCollector = createCustomCollector(collectorType, collectorParams);
            return new CustomRule(customCollector, conditions, customConditions);
        }
        //      Base
        if (!customCollectorRequired) {
            ICollector collector = createBaseCollector(collectorType, collectorParams);
            return new Rule(collector, conditions);
        }

        // Error in creation
        throw new RuntimeException("Conditions and collectors BAD use");
    }

    private static boolean isCustomCondition(String conditionType) {
        switch (conditionType) {
            case COUNT_WITHIN_RANGE:
            case EQUALS_MULTIPLY:
            case EQUALS_SUM:
                return true;
            default:
                return false;
        }
    }

    private static boolean isCustomCollector(String collectorType) {
        switch (collectorType) {
            case CUSTOM:
            case CUSTOM_VALUED:
                return true;
            default:
                return false;
        }
    }

    private static ICondition createBaseCondition(Neighborhood neighborhood, ConditionMapper conditionMapper) {
        String type = conditionMapper.getType();
        List<Integer> params = conditionMapper.getParams();
        switch (type) {
            case UNIQUE:
                return new UniqueCondition();
            case GREATER_THAN:
                int minValue = params.get(0);
                return new GreaterThanCondition(minValue);
            case LESSER_THAN:
                int maxValue = params.get(0);
                return new LesserThanCondition(maxValue);
            case LESSER_THAN_SLOT_SIZE:
                return new LesserThanSlotSize();
            case FILLED:
                return new FilledCondition();
            case NO_BRANCHED_OFF:
                int filterValue = params.get(0);
                return new NoBranchedOffCondition(neighborhood, filterValue);
            case SINGLE_LOOP:
                return new SingleLoopCondition(neighborhood);
            case NO_LOOP:
                return new NoLoopCondition(neighborhood);
            case SLOTS_OF_SIZE:
                int slotSize = params.get(0);
                return new SlotsOfSizeCondition(neighborhood, slotSize);
            case MIN_MATCH_AT_VALUE_DISTANCE:
                return new MinMatchAtValueDistance();
            default:
                throw new RuntimeException("Parsing error! Check conditions' name. " + type + " NOT VALID!");
        }
    }

    private static ICustomCondition createCustomCondition(ConditionMapper conditionMapper) {
        String type = conditionMapper.getType();
        switch (type) {
            case COUNT_WITHIN_RANGE:
                return new CountWithinRangeCondition();
            case EQUALS_MULTIPLY:
                return new EqualsMultiplyCondition();
            case EQUALS_SUM:
                return new EqualsSumCondition();
            default:
                throw new RuntimeException("Parsing error! Check conditions' name. " + type + " NOT VALID!");
        }
    }

    private static ICustomCollector createCustomCollector(String type, List<Integer> params) {
        switch (type) {
            case CUSTOM:
                return new CustomCollector();
            case CUSTOM_VALUED:
                return new CustomValuedCollector(params);
            default:
                throw new RuntimeException("Parsing error! Check collectors' name. " + type + " NOT VALID!");
        }
    }

    private static ICollector createBaseCollector(String type, List<Integer> params) {
        switch (type) {
            case ALL:
                return new AllCollector();
            case ROWS:
                return new RowCollector();
            case COLUMNS:
                return new ColumnCollector();
            case BLOCKS:
                int blockSize = params.get(0);
                return new BlockCollector(blockSize);
            case VALUED:
                return new ValuedCollector(params);
            case CUSTOM:
                return new CustomCollector();
            case CUSTOM_VALUED:
                return new CustomValuedCollector(params);
            default:
                return createCustomCollector(type, params);
        }
    }


}
