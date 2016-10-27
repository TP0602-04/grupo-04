package ar.fiuba.tdd.grupo04.json.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("CPD-START")
public class JsonCellGroup {
    @SerializedName("rowOffset")
    private Integer rowOffset;
    @SerializedName("columnOffset")
    private Integer columnOffset;
    @SerializedName("rowLarge")
    private Integer rowLarge;
    @SerializedName("columnLarge")
    private Integer columnLarge;

    public Integer getRowOffset() {
        return rowOffset;
    }

    public Integer getColumnOffset() {
        return columnOffset;
    }

    public Integer getRowLarge() {
        return rowLarge;
    }

    public Integer getColumnLarge() {
        return columnLarge;
    }
}
