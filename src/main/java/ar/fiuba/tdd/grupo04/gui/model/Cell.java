package ar.fiuba.tdd.grupo04.gui.model;

import com.google.gson.annotations.SerializedName;

public class Cell {
    @SerializedName("x")
    private int x;
    @SerializedName("y")
    private int y;
    @SerializedName("value")
    private String value;

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public String getValue() {
        return value;
    }
}
