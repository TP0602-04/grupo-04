package ar.fiuba.tdd.grupo04.model.board;

import java.util.Objects;

public class Coordinate {
    private final Integer row;
    private final Integer column;

    public Coordinate(Integer row, Integer column) {
        this.row = row;
        this.column = column;
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

    @Override
    public int hashCode() {
        int hash = 17;
        hash = ((hash + row) << 5) - (hash + row);
        hash = ((hash + column) << 5) - (hash + column);
        return hash;
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

    public Coordinate plus(Coordinate summand) {
        return new Coordinate(this.row + summand.row, this.column + summand.column);
    }

    public boolean isAround(Coordinate coordinate) {
        return (column.equals(coordinate.column()) && (row.equals(coordinate.row() + 1) || row.equals(coordinate.row() - 1))) ||
                (row.equals(coordinate.row()) && (column.equals(coordinate.column() + 1) || column.equals(coordinate.column() - 1)));
    }
}
