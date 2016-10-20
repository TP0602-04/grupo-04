package ar.fiuba.tdd.grupo04.gui.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Scenario {
    @SerializedName("cellGroups")
    private List<CellGroup> cellGroups;

    public List<CellGroup> getCellGroups() {
        return cellGroups;
    }
}
