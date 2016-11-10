package ar.fiuba.tdd.grupo04.json.game;

import com.google.gson.annotations.SerializedName;

public class StructureMapper {
    public static final String ODD = "odd";
    public static final String EVEN = "even";

    @SerializedName("columnRange")
    private String columnRange;
    @SerializedName("rowRange")
    private String rowRange;
    @SerializedName("value")
    private int value;

    public String getColumnRange() {
        return columnRange;
    }

    public String getRowRange() {
        return rowRange;
    }

    public int getValue() {
        return value;
    }
}
