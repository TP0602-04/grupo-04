package ar.fiuba.tdd.grupo04.gui.model;

import com.google.gson.annotations.SerializedName;

public class Board {
    @SerializedName("size")
    private int size;
    @SerializedName("defaultCellType")
    private String defaultCellType;

    public int getSize() {
        return size;
    }

    public String getDefaultCellType() {
        return defaultCellType;
    }

}
