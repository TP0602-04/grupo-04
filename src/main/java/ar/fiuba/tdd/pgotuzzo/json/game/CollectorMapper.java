package ar.fiuba.tdd.pgotuzzo.json.game;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectorMapper {
    @SerializedName("type")
    private String type;
    @SerializedName("params")
    private List<Integer> params;
}
