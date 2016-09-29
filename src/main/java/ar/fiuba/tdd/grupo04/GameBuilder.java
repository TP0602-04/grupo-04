package ar.fiuba.tdd.grupo04;

import java.util.List;

public class GameBuilder implements IGameBuilder {
	final Game game = new Game();

	public IGame getGame() {
		return game;
	}
	public GameBuilder setGridSize(final Integer rows, final Integer columns) {
		game.setGrid(new Grid(rows, columns));
		return this;
	}

	public GameBuilder setCellValue(final Integer row, final Integer column, final Integer value) {
		game.fillCell(row, column, value);
		return this;
	}
	// esto esta mal hay que mejorarlo, pero necesitamos avanzar
	public GameBuilder setRules(final List<IRule> rules) {
		game.setRules(rules);
		return this;
	}
}
