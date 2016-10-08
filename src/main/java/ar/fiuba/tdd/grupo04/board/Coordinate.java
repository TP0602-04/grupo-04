package ar.fiuba.tdd.grupo04.board;

public class Coordinate {
    private final Integer row;
    private final Integer column;

    public Coordinate(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

    public Integer column() {
        return column;
    }

    public Integer row() {
        return row;
    }
}
