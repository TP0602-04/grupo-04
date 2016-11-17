package ar.fiuba.tdd.grupo04.json.game;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RuleMapper {
    @SerializedName("collector")
    private BaseElementMapper collector;
    @SerializedName("conditions")
    private List<BaseElementMapper> conditions;

    public BaseElementMapper getCollector() {
        return collector;
    }

    public List<BaseElementMapper> getConditions() {
        return conditions;
    }
}
