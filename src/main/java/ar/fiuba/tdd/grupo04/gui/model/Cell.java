package ar.fiuba.tdd.grupo04.gui.model;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import com.google.gson.annotations.SerializedName;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
