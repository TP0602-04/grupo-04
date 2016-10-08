package ar.fiuba.tdd.grupo04.board.reference.builder;

import ar.fiuba.tdd.grupo04.board.reference.IReferencedGroup;

public interface IReferencedGroupBuilder<S> {
    IReferencedGroup<S> createReference();
}
