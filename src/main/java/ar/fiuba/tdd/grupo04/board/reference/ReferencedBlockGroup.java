package ar.fiuba.tdd.grupo04.board.reference;

import ar.fiuba.tdd.grupo04.board.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class ReferencedBlockGroup<S> implements IReferencedGroup<S> {
    final Integer rowOffset;
    final Integer columnOffset;
    final Integer rowLarge;
    final Integer columnLarge;
    final S referencedValue;

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
        final List coordinates = new ArrayList<>();
        for (int i = rowOffset; i < (rowOffset + rowLarge); i++) {
            for (int j = columnOffset; j < (columnOffset + columnLarge); j++) {
                coordinates.add(new Coordinate(i, j));
            }
        }
        return coordinates;
    }
}


