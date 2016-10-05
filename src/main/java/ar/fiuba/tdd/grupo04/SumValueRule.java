package ar.fiuba.tdd.grupo04.rules;

import ar.fiuba.tdd.grupo04.grid.IGrid;
import ar.fiuba.tdd.grupo04.groupers.IRefenceCellGrouper;

import java.util.List;

public class SumValueRule<Integer> extends IRule {
	private IRefenceCellGrouper<Integer, Integer> refenceCellGrouper;
	private List<Integer> values;
	private List<List<Integer>> refenceCellGroup;

	public SumValueRule(IRefenceCellGrouper<Integer, Integer> refenceCellGrouper) {
		this.cellGrouper = refenceCellGrouper;
		this.refenceCellGrouper = refenceCellGrouper;
	}

	@Override
	public void startRule(IGrid grid) {
		cellsGroup = cellGrouper.createCellGroup(grid);
		refenceCellGroup = cellGrouper.createCellGroup(grid);
		values = refenceCellGrouper.getReferencedValues(grid);
	}

	@Override
	public boolean check() {
		// sorry, ya no puedo pensar. esto se resuelve cn el streamutils la funcion zip
		// http://rxmarbles.com/#zip
		boolean checked = true;
		for (int i = 0; i < values.size(); i++) {
			if (values.get(i).equals(refenceCellGroup.get(i).stream().mapToInt(t -> (int)t).sum())) {
				checked = false;
			}
		}
		return checked;
	}

	@Override
	protected boolean checkList(List cells) {
		// creo q murio gente despues de ver esta linea D:
		// los antipatterns son una sensacion (?
		// Liskov quien te conoce?
		return true;
	}
}
