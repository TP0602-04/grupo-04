package ar.fiuba.tdd.grupo04;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridTests {
	private IGrid grid;

	@Before
	public void init(){
		this.grid = new Grid(4, 5);
	}

	@Test
	public void putAndGet() {
		this.grid.put(123, 2, 4);
		assertEquals(this.grid.get(2, 4).getValue(), (Integer)123);
	}
}
