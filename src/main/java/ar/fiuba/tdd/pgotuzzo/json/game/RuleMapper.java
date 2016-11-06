package ar.fiuba.tdd.pgotuzzo.json.game;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RuleMapper {
    @SerializedName("collector")
    private CollectorMapper collector;
    @SerializedName("conditions")
    private List<ConditionMapper> conditions;

    public CollectorMapper getCollector() {
        return collector;
    }

    public List<ConditionMapper> getConditions() {
        return conditions;
    }
}
