package ar.fiuba.tdd.grupo04.json.game;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GameMapper {
    @SerializedName("board")
    private BoardMapper board;
    @SerializedName("loseRules")
    private List<RuleMapper> loseRules;
    @SerializedName("winRules")
    private List<RuleMapper> winRules;

    public BoardMapper getBoard() {
        return board;
    }

    public List<RuleMapper> getLoseRules() {
        return loseRules;
    }

    public List<RuleMapper> getWinRules() {
        return winRules;
    }

}
