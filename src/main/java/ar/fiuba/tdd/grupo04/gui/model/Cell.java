package ar.fiuba.tdd.grupo04.gui.model;

import com.google.gson.annotations.SerializedName;

public class Cell {
    @SerializedName("row")
    private int row;
    @SerializedName("column")
    private int column;
    @SerializedName("value")
    private String value;

    public int row() {
        return row;
    }

    public int column() {
        return column;
    }

    public String getValue() {
        return value;
    }
}
