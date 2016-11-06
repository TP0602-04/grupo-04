package ar.fiuba.tdd.pgotuzzo;

import com.sun.istack.internal.Nullable;

public class Cell {
    private Coordinate coordinate;
    private Integer value;
    private boolean isEditable;

    public Cell(Coordinate coordinate) {
        this(coordinate, null);
    }

    public Cell(Coordinate coordinate, Integer value) {
        this.coordinate = coordinate;
        this.value = value;
        this.isEditable = true;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Nullable
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        if (isEditable) {
            this.value = value;
        }
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void edit(boolean isEditable) {
        this.isEditable = isEditable;
    }

}
