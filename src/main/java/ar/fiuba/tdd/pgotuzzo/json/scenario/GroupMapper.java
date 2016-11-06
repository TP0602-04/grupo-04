package ar.fiuba.tdd.pgotuzzo.json.scenario;

import com.google.gson.annotations.SerializedName;

public class GroupMapper {
    @SerializedName("columnOffset")
    private int columnOffset;
    @SerializedName("rowOffset")
    private int rowOffset;
    @SerializedName("rowLarge")
    private int rowLarge;
    @SerializedName("columnLarge")
    private int columnLarge;
}
