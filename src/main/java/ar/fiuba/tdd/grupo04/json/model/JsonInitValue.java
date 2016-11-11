package ar.fiuba.tdd.grupo04.json.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("CPD-START")
public class JsonInitValue {
    @SerializedName("row")
    private Integer row;
    @SerializedName("column")
    private Integer column;
    @SerializedName("value")
    private Integer value;

    public Integer getRow() {
        return row;
    }

    public Integer getColumn() {
        return column;
    }

    public Integer getValue() {
        return value;
    }
}
