package ar.fiuba.tdd.grupo04.json.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonGame {
    @SerializedName("board")
    private JsonBoard board;
    @SerializedName("winRules")
    private List<JsonRules> winRules;
    @SerializedName("loseRules")
    private List<JsonRules> loseRules;

    public JsonBoard getBoard() {
        return board;
    }

    public List<JsonRules> getWinRules() {
        return winRules;
    }

    public List<JsonRules> getLoseRules() {
        return loseRules;
    }
}
