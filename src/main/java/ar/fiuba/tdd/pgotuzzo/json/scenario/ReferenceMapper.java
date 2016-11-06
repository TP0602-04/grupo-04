package ar.fiuba.tdd.pgotuzzo.json.scenario;

import com.google.gson.annotations.SerializedName;

public class ReferenceMapper {
    @SerializedName("value")
    private int value;
    @SerializedName("group")
    private GroupMapper group;
}

