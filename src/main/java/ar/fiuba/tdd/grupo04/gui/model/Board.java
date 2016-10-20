package ar.fiuba.tdd.grupo04.gui.model;

import com.google.gson.annotations.SerializedName;

public class Board {
    @SerializedName("size")
    private int size;
    @SerializedName("cellType")
    private String defaultCellType;
    @SerializedName("referenceType")
    private String referenceType;

    public int getSize() {
        return size;
    }

    public String getDefaultCellType() {
        return defaultCellType;
    }

}
