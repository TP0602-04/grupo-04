package ar.fiuba.tdd.grupo04;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberCellTests {

	private ICell cell;

	@Before
	public void init(){
		this.cell = new NumberCell();
	}

	@Test
	public void setAndGet() {
		this.cell.setValue(123);
		assertEquals(this.cell.getValue(), (Integer)123);
	}
}
