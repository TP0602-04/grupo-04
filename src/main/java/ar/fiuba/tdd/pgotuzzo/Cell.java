package ar.fiuba.tdd.pgotuzzo;

public class Cell {
    public static final int DEFAULT_VALUE = 0;

    private Coordinate coordinate;
    private int value;
    private boolean isEditable;

    public Cell(Coordinate coordinate) {
        this(coordinate, DEFAULT_VALUE);
    }

    public Cell(Coordinate coordinate, int value) {
        this.coordinate = coordinate;
        this.value = value;
        this.isEditable = true;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
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
