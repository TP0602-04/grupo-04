package ar.fiuba.tdd.grupo04.json.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonMoves {
    @SerializedName("inputs")
    public List<JsonMove> inputs;
}
