package ar.fiuba.tdd.grupo04.rule.condition;

public class ConditionFactory {

    public static ICondition create(String type) throws Exception{
    	ICondition condition;
    	switch (type) {
    		case "AllFilledCondition":
    			condition = new AllFilledCondition();
    			break;
    		case "AllGreaterThanCondition":
    			condition = new AllGreaterThanCondition();
    			break;
    		case "AllLesserThanCondition":
    			condition = new AllLesserThanCondition();
    			break;
    		/*case "AllMarkedContiguousCondition":
    			condition = new AllMarkedContiguousCondition();
    			break;
    		case "CountBiCondition":
    			condition = new CountBiCondition();
    			break;
    		case "CountCondition":
    			condition = new CountCondition();
    			break;
    		case "EmptyContiguousInGroupCondition":
    			condition = new EmptyContiguousInGroupCondition();
    			break;
    		case "HasOneCondition":
    			condition = new HasOneCondition();
    			break;*/
    		case "MultiplyCondition":
    			condition = new MultiplyCondition();
    			break;
    		/*case "OneLoopCondition":
    			condition = new OneLoopCondition();
    			break;*/
    		case "SumCondition":
    			condition = new SumCondition();
    			break;
    		case "UniqueCondition":
    			condition = new UniqueCondition();
    			break;
    		default:
    			throw new Exception("Unknown Condition");//TODO: Use custom exception
        }
        return condition;
    }
}
