package ar.fiuba.tdd.grupo04.board.reference;

import ar.fiuba.tdd.grupo04.board.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class ReferencedBlockGroup<S> implements IReferencedGroup<S> {
    private final Integer rowOffset;
    private final Integer columnOffset;
    private final Integer rowLarge;
    private final Integer columnLarge;
    private final S referencedValue;

    public ReferencedBlockGroup(Integer rowOffset, Integer columnOffset, Integer rowLarge, Integer columnLarge, S referencedValue) {
        this.rowOffset = rowOffset;
        this.columnOffset = columnOffset;
        this.rowLarge = rowLarge;
        this.columnLarge = columnLarge;
        this.referencedValue = referencedValue;
    }

    @Override
    public S getValue() {
        return referencedValue;
    }

    @Override
    public List<Coordinate> getCoordinates() {
        final List<Coordinate> coordinates = new ArrayList<>();
        for (int i = rowOffset; i < (rowOffset + columnLarge); i++) {
            for (int j = columnOffset; j < (columnOffset + rowLarge); j++) {
                coordinates.add(new Coordinate(i, j));
            }
        }
        return coordinates;
    }
}


