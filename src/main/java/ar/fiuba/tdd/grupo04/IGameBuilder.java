package ar.fiuba.tdd.grupo04;

import java.util.List;

public interface IGameBuilder {
	public IGame getGame();
	public IGameBuilder setGridSize(final Integer rows, final Integer columns);
	public IGameBuilder setCellValue(final Integer row, final Integer column, final Integer value);
	// esto esta mal, pero necesitamos avanzar
	public IGameBuilder setRules(final List<IRule> rules);
}
