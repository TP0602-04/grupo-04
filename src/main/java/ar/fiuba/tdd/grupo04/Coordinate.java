package ar.fiuba.tdd.grupo04;

public class Coordinate {
    private int row;
    private int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int column() {
        return column;
    }

    public int row() {
        return row;
    }

    public double distance(Coordinate coordinate) {
        int deltaRow = Math.abs(row - coordinate.row);
        int deltaColumn = Math.abs(column - coordinate.column);
        return Math.sqrt(Math.pow(deltaRow, 2) + Math.pow(deltaColumn, 2));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coordinate) {
            return ((Coordinate) obj).column == column && ((Coordinate) obj).row == row;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = ((hash + row) << 5) - (hash + row);
        hash = ((hash + column) << 5) - (hash + column);
        return hash;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}
