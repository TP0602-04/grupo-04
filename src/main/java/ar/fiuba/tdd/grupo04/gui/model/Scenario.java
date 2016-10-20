package ar.fiuba.tdd.grupo04.gui.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Scenario {
    @SerializedName("initialValues")
    private List<CellGroup> initialValues;
    @SerializedName("references")
    private List<Reference> references;
    @SerializedName("ui")
    private List<UiCellGroup> ui;

    public List<CellGroup> getinitialValues() {
        return initialValues;
    }

    public List<Reference> getReferences() {
        return references;
    }

    public List<UiCellGroup> getUtilCells() {
        return ui;
    }
}
