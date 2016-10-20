package ar.fiuba.tdd.grupo04.json.model;

import com.google.gson.annotations.SerializedName;

public class JsonRules {
    @SerializedName("collector")
    private JsonCollector collector;
    @SerializedName("condition")
    private String condition;

    public JsonCollector getCollector() {
        return collector;
    }

    public String getCondition() {
        return condition;
    }
}
