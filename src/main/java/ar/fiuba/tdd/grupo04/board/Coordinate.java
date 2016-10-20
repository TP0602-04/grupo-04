package ar.fiuba.tdd.grupo04.board;

import java.util.Objects;

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

    public Coordinate minus(Coordinate subtrahend) {
        return new Coordinate(this.row - subtrahend.row, this.column - subtrahend.column);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        return Objects.equals(row, ((Coordinate) obj).row) && Objects.equals(column, ((Coordinate) obj).column);
    }
}
