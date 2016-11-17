package ar.fiuba.tdd.grupo04.json.scenario;

import com.google.gson.annotations.SerializedName;

import ar.fiuba.tdd.grupo04.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class SlotMapper {
    @SerializedName("values")
    private List<Integer> values;
    @SerializedName("groups")
    private List<GroupMapper> groups;

    public List<Integer> getValues() {
        return values;
    }

    public List<Coordinate> getCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        groups.forEach(
                groupMapper -> {
                List<Coordinate> coordinateList = groupMapper.getCoordinates();
                coordinates.addAll(coordinateList);
            }
        );
        return coordinates;
    }
}

