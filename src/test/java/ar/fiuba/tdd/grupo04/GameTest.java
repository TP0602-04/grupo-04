package ar.fiuba.tdd.grupo04;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class GameTest {
	@Mock
	IRule rule;
	@Mock
	IRule rule2;
	@Mock
	IGrid grid;

	@Test
	public void testCheckOneRuleOk() {
		when(rule.check()).thenReturn(true);
		final List<IRule> rules = Arrays.asList(rule);

		final Game game = new Game(grid, rules);

		assertTrue(game.checkRules());
		verify(rule).check();
	}

	@Test
	public void testCheckTwoRulesFails() {
		when(rule.check()).thenReturn(true);
		when(rule2.check()).thenReturn(false);
		final List<IRule> rules = Arrays.asList(rule, rule2);

		final Game game = new Game(grid, rules);

		assertFalse(game.checkRules());
		verify(rule).check();
		verify(rule2).check();
	}

	@Test
	public void testCheckTwoRulesOk() {
		when(rule.check()).thenReturn(true);
		when(rule2.check()).thenReturn(true);
		final List<IRule> rules = Arrays.asList(rule, rule2);

		final Game game = new Game(grid, rules);

		assertTrue(game.checkRules());
		verify(rule).check();
		verify(rule2).check();
	}
}
