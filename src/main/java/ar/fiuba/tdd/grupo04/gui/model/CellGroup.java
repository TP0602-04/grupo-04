package ar.fiuba.tdd.grupo04.gui.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CellGroup {
    @SerializedName("type")
    private String type;
    @SerializedName("editable")
    private boolean editable;
    @SerializedName("cells")
    private List<Cell> cellList;

    public String getType() {
        return type;
    }

    public List<Cell> getCells() {
        return cellList;
    }
}
