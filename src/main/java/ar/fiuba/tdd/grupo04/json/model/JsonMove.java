package ar.fiuba.tdd.grupo04.json.model;

import com.google.gson.annotations.SerializedName;

public class JsonMove {
    @SerializedName("x")
    public Integer x;

    @SerializedName("y")
    public Integer y;

    @SerializedName("value")
    public Integer value;
}
