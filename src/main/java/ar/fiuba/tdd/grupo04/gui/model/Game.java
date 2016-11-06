package ar.fiuba.tdd.grupo04.gui.model;

import com.google.gson.annotations.SerializedName;

/*
 * Json mapper for GUI configuration
 */
public class Game {
    @SerializedName("board")
    private Board board;
    @SerializedName("scenario")
    private Scenario scenario;

    public Board getBoard() {
        return board;
    }

    public Scenario getScenario() {
        return scenario;
    }
}
