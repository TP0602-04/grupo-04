package ar.fiuba.tdd.grupo04.json.scenario;

import com.google.gson.annotations.SerializedName;

public class CellMapper {
    @SerializedName("column")
    private int column;
    @SerializedName("row")
    private int row;
    @SerializedName("value")
    private int value;

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getValue() {
        return value;
    }
}
