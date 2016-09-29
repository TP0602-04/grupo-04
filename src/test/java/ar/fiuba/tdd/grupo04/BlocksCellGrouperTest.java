package ar.fiuba.tdd.grupo04;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BlocksCellGrouperTest {
	private ICellGrouper cellGrouperFactory;
	private IGrid grid;

	@Before
	public void init(){
		this.cellGrouperFactory = new BlocksCellGrouper(2, 3);
		this.grid = new Grid(4, 6);
		this.grid.put(1, 0, 0);
		this.grid.put(2, 0, 1);
		this.grid.put(3, 0, 2);
		this.grid.put(4, 0, 3);
		this.grid.put(5, 0, 4);
		this.grid.put(6, 0, 5);
		this.grid.put(7, 1, 0);
		this.grid.put(8, 1, 1);
		this.grid.put(9, 1, 2);
		this.grid.put(10, 1, 3);
		this.grid.put(11, 1, 4);
		this.grid.put(12, 1, 5);
		this.grid.put(13, 2, 0);
		this.grid.put(14, 2, 1);
		this.grid.put(15, 2, 2);
		this.grid.put(16, 2, 3);
		this.grid.put(17, 2, 4);
		this.grid.put(18, 2, 5);
		this.grid.put(19, 3, 0);
		this.grid.put(20, 3, 1);
		this.grid.put(21, 3, 2);
		this.grid.put(22, 3, 3);
		this.grid.put(23, 3, 4);
		this.grid.put(24, 3, 5);
	}

	@Test
	public void getBlocksOfGrid() {
		List<List<ICell>> columns = this.cellGrouperFactory.createCellGroup(this.grid);
		assertEquals(columns.get(0).get(0).getValue(), (Integer)1);
		assertEquals(columns.get(0).get(1).getValue(), (Integer)2);
		assertEquals(columns.get(0).get(2).getValue(), (Integer)3);
		assertEquals(columns.get(0).get(3).getValue(), (Integer)7);
		assertEquals(columns.get(0).get(4).getValue(), (Integer)8);
		assertEquals(columns.get(0).get(5).getValue(), (Integer)9);

		assertEquals(columns.get(1).get(0).getValue(), (Integer)4);
		assertEquals(columns.get(1).get(1).getValue(), (Integer)5);
		assertEquals(columns.get(1).get(2).getValue(), (Integer)6);
		assertEquals(columns.get(1).get(3).getValue(), (Integer)10);
		assertEquals(columns.get(1).get(4).getValue(), (Integer)11);
		assertEquals(columns.get(1).get(5).getValue(), (Integer)12);

		assertEquals(columns.get(2).get(0).getValue(), (Integer)13);
		assertEquals(columns.get(2).get(1).getValue(), (Integer)14);
		assertEquals(columns.get(2).get(2).getValue(), (Integer)15);
		assertEquals(columns.get(2).get(3).getValue(), (Integer)19);
		assertEquals(columns.get(2).get(4).getValue(), (Integer)20);
		assertEquals(columns.get(2).get(5).getValue(), (Integer)21);

		assertEquals(columns.get(3).get(0).getValue(), (Integer)16);
		assertEquals(columns.get(3).get(1).getValue(), (Integer)17);
		assertEquals(columns.get(3).get(2).getValue(), (Integer)18);
		assertEquals(columns.get(3).get(3).getValue(), (Integer)22);
		assertEquals(columns.get(3).get(4).getValue(), (Integer)23);
		assertEquals(columns.get(3).get(5).getValue(), (Integer)24);
	}
}
