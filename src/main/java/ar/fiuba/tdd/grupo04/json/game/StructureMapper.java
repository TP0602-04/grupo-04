package ar.fiuba.tdd.grupo04.json.game;

import ar.fiuba.tdd.grupo04.Coordinate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StructureMapper {
    @SerializedName("offsetRow")
    private int offsetRow;
    @SerializedName("offsetColumn")
    private int offsetColumn;
    @SerializedName("stepRow")
    private int stepRow;
    @SerializedName("stepColumn")
    private int stepColumn;
    @SerializedName("value")
    private int value;

    public List<Coordinate> getCoordinates(int rowSize, int columnSize) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = offsetRow; i < rowSize; i = i + stepRow) {
            for (int j = offsetColumn; j < columnSize; j = j + stepColumn) {
                Coordinate coordinate = new Coordinate(i, j);
                coordinates.add(coordinate);
            }
        }
        return coordinates;
    }

    public int getValue() {
        return value;
    }
}
