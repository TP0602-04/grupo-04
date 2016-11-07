package ar.fiuba.tdd.grupo04.json.game;

import com.google.gson.annotations.SerializedName;

public class BoardMapper {
    @SerializedName("columns")
    private int columns;
    @SerializedName("rows")
    private int rows;
    @SerializedName("cellType")
    private String cellType;

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
}
