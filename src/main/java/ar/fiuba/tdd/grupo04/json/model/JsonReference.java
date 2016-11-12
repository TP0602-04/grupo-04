package ar.fiuba.tdd.grupo04.json.model;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class JsonReference {
    @SerializedName("value")
    private Integer value;
    @SerializedName("groups")
    private List<JsonCellGroup> groups;

    public Integer getValue() {
        return value;
    }

    public List<Coordinate> getCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        for (JsonCellGroup group : groups) {
            List<Coordinate> groupCoordinates = group.getCoordinates();
            coordinates.addAll(groupCoordinates);
        }
        return coordinates;
    }
}
