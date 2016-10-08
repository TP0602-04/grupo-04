package ar.fiuba.tdd.grupo04.board.reference.builder;

import ar.fiuba.tdd.grupo04.board.reference.IReferencedGroup;
import ar.fiuba.tdd.grupo04.board.reference.ReferencedBlockGroup;

public class ReferencedBlockGroupBuilder<S> implements IReferencedGroupBuilder {
    private Integer rowOffset = 0;
    private Integer columnOffset = 0;
    private Integer rowLarge = 1;
    private Integer columnLarge = 1;
    private Integer referencedValue = 0;

    public IReferencedGroup<S> createReference() {
        final IReferencedGroup reference = new ReferencedBlockGroup(rowOffset, columnOffset, rowLarge, columnLarge, referencedValue);
        clear();
        return reference;
    }

    private void clear() {
        rowOffset = 0;
        columnOffset = 0;
        rowLarge = 1;
        columnLarge = 1;
        referencedValue = 0;
    }

    public ReferencedBlockGroupBuilder rowOffset(Integer newRowOffset) {
        rowOffset = newRowOffset;
        return this;
    }

    public ReferencedBlockGroupBuilder columnOffset(Integer newColumnOffsett) {
        columnOffset = newColumnOffsett;
        return this;
    }

    public ReferencedBlockGroupBuilder rowLarge(Integer newRowLarge) {
        rowLarge = newRowLarge;
        return this;
    }

    public ReferencedBlockGroupBuilder columnLarge(Integer newColumnLarge) {
        columnLarge = newColumnLarge;
        return this;
    }

    public ReferencedBlockGroupBuilder referencedValue(Integer newReferencedValue) {
        referencedValue = newReferencedValue;
        return this;
    }
}
