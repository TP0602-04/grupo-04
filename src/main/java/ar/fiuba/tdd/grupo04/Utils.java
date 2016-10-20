package ar.fiuba.tdd.grupo04;

import ar.fiuba.tdd.grupo04.board.Coordinate;

import java.util.function.Function;

public class Utils {
    public static Function<Coordinate, Boolean> isSegment() {
        return (coordinate) -> ((coordinate.column().intValue() & 1) == 0) != ((coordinate.row().intValue() & 1) == 0);
    }

    public static Function<Coordinate, Boolean> isCell() {
        return (coordinate) -> (coordinate.column().intValue() & 1) == 0 && (coordinate.row().intValue() & 1) == 0;
    }
}
