package ar.fiuba.tdd.grupo04.json.game;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConditionMapper {
    public static final String UNIQUE = "Unique";
    public static final String GREATER_THAN = "GreaterThan";
    public static final String LESSER_THAN = "LesserThan";
    public static final String FILLED = "Filled";
    public static final String EQUALS_SUM = "EqualsSum";
    public static final String EQUALS_MULTIPLY = "EqualsMultiply";
    public static final String NO_BRANCHED_OFF = "NoBranchedOff";
    public static final String NO_LOOP = "NoLoop";
    public static final String SINGLE_LOOP = "SingleLoop";
    public static final String COUNT_WITHIN_RANGE = "CountWithinRange";

    @SerializedName("type")
    private String type;
    @SerializedName("params")
    private List<Integer> params;

    public String getType() {
        return type;
    }

    public List<Integer> getParams() {
        return params;
    }
}
