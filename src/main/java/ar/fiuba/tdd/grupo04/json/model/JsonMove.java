package ar.fiuba.tdd.grupo04.json.model;


import com.google.gson.annotations.SerializedName;

import ar.fiuba.tdd.grupo04.board.Coordinate;

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
