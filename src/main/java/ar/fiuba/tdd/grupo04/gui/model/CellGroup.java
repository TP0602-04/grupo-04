package ar.fiuba.tdd.grupo04.gui.model;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CellGroup {
    @SerializedName("offsetX")
    private int offsetX;
    @SerializedName("offsetY")
    private int offsetY;
    @SerializedName("deltaX")
    private int deltaX;
    @SerializedName("deltaY")
    private int deltaY;

    public List<Cell> getCells() {
        List<Cell> list = new ArrayList<>();

        Coordinate offset = new Coordinate(offsetX, offsetY);
        list.add(new Cell(offset));

        for (int i = 1; i < deltaX; i++) {
            Coordinate coordinate = new Coordinate(offsetX + i, offsetY);
            Cell cell = new Cell(coordinate);
            list.add(cell);
        }

        for (int i = 1; i < deltaY; i++) {
            Coordinate coordinate = new Coordinate(offsetX, offsetY + i);
            Cell cell = new Cell(coordinate);
            list.add(cell);
        }

        return list;
    }
}
