package ar.fiuba.tdd.grupo04.json.scenario;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ScenarioMapper {
    @SerializedName("initialValues")
    private List<CellMapper> initialValues;
    @SerializedName("references")
    private List<SlotMapper> references;

    public List<CellMapper> getInitialValues() {
        return initialValues;
    }

    public List<SlotMapper> getReferences() {
        return references;
    }
}
