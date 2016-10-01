package ar.fiuba.tdd.grupo04.grid;

public class NumberCell implements ICell {
	private Integer value;

	@Override
	public Integer getValue() {
		return this.value;
	}

	@Override
	public void setValue(Integer value) {
		this.value = value;
	}
}
