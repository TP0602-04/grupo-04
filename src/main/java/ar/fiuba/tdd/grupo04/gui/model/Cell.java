package ar.fiuba.tdd.grupo04.gui.model;

import com.google.gson.annotations.SerializedName;

import ar.fiuba.tdd.grupo04.board.Coordinate;

public class Cell {
    @SerializedName("x")
    private int row;
    @SerializedName("y")
    private int column;
    @SerializedName("value")
    private String value;

    public Cell(Coordinate coordinate) {
        row = coordinate.row();
        column = coordinate.column();
    }

    public int row() {
        return row;
    }

    public int column() {
        return column;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
