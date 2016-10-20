package ar.fiuba.tdd.grupo04.json.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonRules {
    @SerializedName("collector")
    private JsonCollector collector;
    @SerializedName("condition")
    private List<String> condition;

    public JsonCollector getCollector() {
        return collector;
    }

    public List<String> getCondition() {
        return condition;
    }
}
