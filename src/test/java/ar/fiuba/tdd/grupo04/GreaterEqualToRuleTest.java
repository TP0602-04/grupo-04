package ar.fiuba.tdd.grupo04;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class GreaterEqualToRuleTest {
	@Mock
	ICell cell;
	@Mock
	ICell cell2;
	@Mock
	ICell cell3;

	@Test
	public void testCheckRuleOk() {
		when(cell.getValue()).thenReturn(2);
		when(cell2.getValue()).thenReturn(4);
		when(cell3.getValue()).thenReturn(5);
		final List<ICell> cells = Arrays.asList(cell, cell2, cell3);

		final GreaterEqualToRule greaterEqualToRule = new GreaterEqualToRule(cells, 1);
		assertTrue(greaterEqualToRule.check());
	}

	@Test
	public void testCheckRuleFails() {
		when(cell.getValue()).thenReturn(3);
		when(cell2.getValue()).thenReturn(3);
		when(cell3.getValue()).thenReturn(4);
		final List<ICell> cells = Arrays.asList(cell, cell2, cell3);

		final GreaterEqualToRule greaterEqualToRule = new GreaterEqualToRule(cells, 5);
		assertFalse(greaterEqualToRule.check());
	}

}
