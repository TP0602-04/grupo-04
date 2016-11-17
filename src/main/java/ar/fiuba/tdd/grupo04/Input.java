package ar.fiuba.tdd.grupo04;

public class Input {
    private Coordinate coordinate;
    private Integer value;

    public Input(Coordinate coordinate, Integer value) {
        this.coordinate = coordinate;
        this.value = value;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Integer getValue() {
        return value;
    }
}
