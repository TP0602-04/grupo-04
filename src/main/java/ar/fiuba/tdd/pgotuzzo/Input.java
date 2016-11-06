package ar.fiuba.tdd.pgotuzzo;

public class Input {
    private Coordinate coordinate;
    private int value;

    public Input(Coordinate coordinate, int value) {
        this.coordinate = coordinate;
        this.value = value;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getValue() {
        return value;
    }
}
