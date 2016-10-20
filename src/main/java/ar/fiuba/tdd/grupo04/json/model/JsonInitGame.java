package ar.fiuba.tdd.grupo04.json.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonInitGame {
    @SerializedName("initialValues")
    private List<JsonInitValue> initialValues;

    public List<JsonInitValue> getInitialValues() {
        return initialValues;
    }
}
