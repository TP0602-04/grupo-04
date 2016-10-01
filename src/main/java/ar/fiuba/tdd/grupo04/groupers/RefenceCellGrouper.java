package ar.fiuba.tdd.grupo04.groupers;

import ar.fiuba.tdd.grupo04.grid.ICell;
import ar.fiuba.tdd.grupo04.grid.IGrid;
import ar.fiuba.tdd.grupo04.grid.IReference;

import java.util.List;
import java.util.stream.Collectors;

public class RefenceCellGrouper implements IRefenceCellGrouper {

	@Override
	public List<List<ICell>> createCellGroup(IGrid grid) {
		final List<IReference> references = grid.getReferences();
		return references.stream().sorted().map(r->r.getReferencedCells(grid)).collect(Collectors.toList());
	}

	@Override
	public List<Integer> getReferencedValues(IGrid grid) {
		final List<IReference> references = grid.getReferences();
		// El sorted hace la magia de q las dos listas esten en el mismo orden
		// esto es re endeble hay q ponerle mas onda
		return references.stream().sorted().map(r->r.getReferencedValue()).collect(Collectors.toList());
	}
}
