package ar.fiuba.tdd.grupo04.json.model;

import com.google.gson.annotations.SerializedName;

public class JsonReference {
    @SerializedName("value")
    private Integer value;
    @SerializedName("group")
    private JsonCellGroup group;

    public Integer getValue() {
        return value;
    }

    public JsonCellGroup getGroup() {
        return group;
    }

}
