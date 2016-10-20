package ar.fiuba.tdd.grupo04.gui.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UiCellGroup {
    @SerializedName("type")
    private String cellType;
    @SerializedName("value")
    private String value;
    @SerializedName("group")
    private CellGroup group;

    public String getCellType() {
        return cellType;
    }

    public List<Cell> getCells() {
        List<Cell> cells = group.getCells();
        for (Cell cell : cells) {
            cell.setValue(value);
        }
        return cells;
    }
}
