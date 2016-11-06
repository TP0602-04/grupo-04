package ar.fiuba.tdd.pgotuzzo.json.scenario;

import ar.fiuba.tdd.pgotuzzo.Coordinate;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SlotMapper {
    @SerializedName("value")
    private int value;
    @SerializedName("group")
    private GroupMapper group;

    public int getValue() {
        return value;
    }

    public List<Coordinate> getCoordinates() {
        return group.getCoordinates();
    }
}

