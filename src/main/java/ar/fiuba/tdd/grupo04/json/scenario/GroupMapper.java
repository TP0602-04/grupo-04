package ar.fiuba.tdd.grupo04.json.scenario;

import ar.fiuba.tdd.grupo04.Coordinate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GroupMapper {
    @SerializedName("columnOffset")
    private int columnOffset;
    @SerializedName("rowOffset")
    private int rowOffset;
    @SerializedName("rowLarge")
    private int rowLarge;
    @SerializedName("columnLarge")
    private int columnLarge;

    public List<Coordinate> getCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < rowLarge; i++) {
            for (int j = 0; j < columnLarge; j++) {
                int row = rowOffset + j;
                int column = columnOffset + i;
                Coordinate coordinate = new Coordinate(row, column);
                coordinates.add(coordinate);
            }
        }
        return coordinates;
    }
}
