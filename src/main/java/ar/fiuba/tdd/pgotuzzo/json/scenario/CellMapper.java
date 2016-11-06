package ar.fiuba.tdd.pgotuzzo.json.scenario;

import com.google.gson.annotations.SerializedName;

public class CellMapper {
    @SerializedName("column")
    private int column;
    @SerializedName("row")
    private int row;
    @SerializedName("value")
    private int value;
}
