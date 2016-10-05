package ar.fiuba.tdd.grupo04.groupers;

import ar.fiuba.tdd.grupo04.grid.IGrid;
import ar.fiuba.tdd.grupo04.grid.IReference;

import java.util.List;
import java.util.stream.Collectors;

public class RefenceCellGrouper<T, S> implements IRefenceCellGrouper<T, S> {

	@Override
	public List<List<T>> createCellGroup(IGrid<T, S> grid) {
		final List<IReference<T, S>> references = grid.getReferences();
		return references.stream().sorted().map(r->r.getReferencedCells(grid)).collect(Collectors.toList());
	}

	@Override
	public List<S> getReferencedValues(IGrid<T, S> grid) {
		final List<IReference<T, S>> references = grid.getReferences();
		// El sorted hace la magia de q las dos listas esten en el mismo orden
		// esto es re endeble hay q ponerle mas onda
		return references.stream().sorted().map(r->r.getReferencedValue()).collect(Collectors.toList());
	}
}
