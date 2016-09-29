package ar.fiuba.tdd.grupo04;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ColumnsCellGrouperTest {
	private ICellGrouper cellGrouperFactory;
	private IGrid grid;

	@Before
	public void init(){
		this.cellGrouperFactory = new ColumnsCellGrouper();
		this.grid = new Grid(3, 4);
		this.grid.put(1, 0, 0);
		this.grid.put(2, 0, 1);
		this.grid.put(3, 0, 2);
		this.grid.put(4, 0, 3);
		this.grid.put(5, 1, 0);
		this.grid.put(6, 1, 1);
		this.grid.put(7, 1, 2);
		this.grid.put(8, 1, 3);
		this.grid.put(9, 2, 0);
		this.grid.put(10, 2, 1);
		this.grid.put(11, 2, 2);
		this.grid.put(12, 2, 3);
	}

	@Test
	public void getColumnsOfGrid() {
		List<List<ICell>> columns = this.cellGrouperFactory.createCellGroup(this.grid);
		assertEquals(columns.get(0).get(0).getValue(), (Integer)1);
		assertEquals(columns.get(0).get(1).getValue(), (Integer)5);
		assertEquals(columns.get(0).get(2).getValue(), (Integer)9);

		assertEquals(columns.get(1).get(0).getValue(), (Integer)2);
		assertEquals(columns.get(1).get(1).getValue(), (Integer)6);
		assertEquals(columns.get(1).get(2).getValue(), (Integer)10);

		assertEquals(columns.get(2).get(0).getValue(), (Integer)3);
		assertEquals(columns.get(2).get(1).getValue(), (Integer)7);
		assertEquals(columns.get(2).get(2).getValue(), (Integer)11);

		assertEquals(columns.get(3).get(0).getValue(), (Integer)4);
		assertEquals(columns.get(3).get(1).getValue(), (Integer)8);
		assertEquals(columns.get(3).get(2).getValue(), (Integer)12);
	}
}
