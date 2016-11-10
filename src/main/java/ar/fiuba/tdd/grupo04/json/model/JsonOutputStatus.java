package ar.fiuba.tdd.grupo04.json.model;

import com.google.gson.annotations.SerializedName;

public class JsonOutputStatus {
    @SerializedName("status")
    private String status;

    public String getStatus() {
        return status;
    }
}
