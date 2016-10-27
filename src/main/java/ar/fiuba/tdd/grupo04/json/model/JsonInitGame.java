package ar.fiuba.tdd.grupo04.json.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonInitGame {
    @SerializedName("initialValues")
    private List<JsonInitValue> initialValues;
    @SerializedName("references")
    private List<JsonReference> references;

    public List<JsonInitValue> getInitialValues() {
        return initialValues;
    }

    public List<JsonReference> getReferences() {
        return references;
    }
}
