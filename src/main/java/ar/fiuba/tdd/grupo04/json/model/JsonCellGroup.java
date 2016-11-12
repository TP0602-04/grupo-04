package ar.fiuba.tdd.grupo04.json.model;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class JsonCellGroup {
    @SerializedName("offsetX")
    private Integer offsetX;
    @SerializedName("offsetY")
    private Integer offsetY;
    @SerializedName("deltaX")
    private Integer deltaX;
    @SerializedName("deltaY")
    private Integer deltaY;

    public List<Coordinate> getCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = offsetX; i < offsetX + deltaX; i++) {
            for (int j = offsetY; j < offsetY + deltaY; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                coordinates.add(coordinate);
            }
        }
        return coordinates;
    }
}
