package ar.fiuba.tdd.grupo04.json.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonCollector {
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
