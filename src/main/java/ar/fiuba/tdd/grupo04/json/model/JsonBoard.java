package ar.fiuba.tdd.grupo04.json.model;

import com.google.gson.annotations.SerializedName;

public class JsonBoard {
    @SerializedName("rows")
    private Integer rows;
    @SerializedName("columns")
    private Integer columns;
    @SerializedName("inputType")
    private String inputType;

    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public String getInputType() {
        return inputType;
    }
}
