package ar.fiuba.tdd.grupo04.json.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("CPD-START")
public class JsonCellGroup {
    @SerializedName("offsetX")
    private Integer offsetX;
    @SerializedName("offsetY")
    private Integer offsetY;
    @SerializedName("deltaX")
    private Integer deltaX;
    @SerializedName("deltaY")
    private Integer deltaY;

    public Integer getOffsetX() {
        return offsetX;
    }

    public Integer getOffsetY() {
        return offsetY;
    }

    public Integer getDeltaX() {
        return deltaX;
    }

    public Integer getDeltaY() {
        return deltaY;
    }
}
