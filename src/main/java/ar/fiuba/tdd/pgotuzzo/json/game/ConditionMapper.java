package ar.fiuba.tdd.pgotuzzo.json.game;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConditionMapper {
    public static final String UNIQUE = "Unique";
    public static final String GREATER_THAN = "GreaterThan";
    public static final String LESSER_THAN = "LesserThan";
    public static final String FILLED = "Filled";

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