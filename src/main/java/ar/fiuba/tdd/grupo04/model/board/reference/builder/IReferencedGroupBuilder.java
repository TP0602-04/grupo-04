package ar.fiuba.tdd.grupo04.model.board.reference.builder;

import ar.fiuba.tdd.grupo04.model.board.reference.IReferencedGroup;

public interface IReferencedGroupBuilder<S> {
    IReferencedGroup<S> createReference();
}
