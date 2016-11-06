package ar.fiuba.tdd.pgotuzzo.json.scenario;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ScenarioMapper {
    @SerializedName("initialValues")
    private List<CellMapper> initialValues;
    @SerializedName("references")
    private List<ReferenceMapper> references;

    public List<CellMapper> getInitialValues() {
        return initialValues;
    }

    public List<ReferenceMapper> getReferences() {
        return references;
    }
}
