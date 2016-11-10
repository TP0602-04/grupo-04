package ar.fiuba.tdd.grupo04.json.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonOutput {
    @SerializedName("outputs")
    private List<JsonOutputStatus> outputs;

    public List<JsonOutputStatus> getOutputs() {
        return outputs;
    }

}
