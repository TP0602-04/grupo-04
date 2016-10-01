package ar.fiuba.tdd.grupo04.rules;

import ar.fiuba.tdd.grupo04.grid.ICell;
import ar.fiuba.tdd.grupo04.grid.IGrid;
import ar.fiuba.tdd.grupo04.groupers.IRefenceCellGrouper;

import java.util.List;

public class SumValueRule extends IRule {
	private IRefenceCellGrouper refenceCellGrouper;
	private List<Integer> values;

	public SumValueRule(IRefenceCellGrouper refenceCellGrouper) {
		this.cellGrouper = refenceCellGrouper;
		this.refenceCellGrouper = refenceCellGrouper;
	}

	@Override
	public void startRule(IGrid grid) {
		cellsGroup = cellGrouper.createCellGroup(grid);
		values = refenceCellGrouper.getReferencedValues(grid);
	}

	@Override
	public boolean check() {
		// sorry, ya no puedo pensar. esto se resuelve cn el streamutils la funcion zip
		// http://rxmarbles.com/#zip
		boolean checked = true;
		for (int i = 0; i < values.size(); i++) {
			if (values.get(i).equals(cellsGroup.get(i).stream().mapToInt(ICell::getValue).sum())) {
				checked = false;
			}
		}
		return checked;
	}

	@Override
	protected boolean checkList(List<ICell> cells) {
		// creo q murio gente despues de ver esta linea D:
		// los antipatterns son una sensacion (?
		// Liskov quien te conoce?
		return true;
	}
}
