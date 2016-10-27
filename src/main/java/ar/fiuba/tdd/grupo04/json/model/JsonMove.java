package ar.fiuba.tdd.grupo04.json.model;

import ar.fiuba.tdd.grupo04.board.Coordinate;

import com.google.gson.annotations.SerializedName;

public class JsonMove {
    @SerializedName("row")
    private Integer row;

    @SerializedName("column")
    private Integer column;

    @SerializedName("value")
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public Coordinate getCoordinate() {
        return new Coordinate(row, column);
    }
}
