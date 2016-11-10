package ar.fiuba.tdd.grupo04.model.inputs;

public class NumericInputModification implements IInputModification {
    private Integer value;

    public NumericInputModification(Integer value) {
        this.value = value;
    }

    @Override
    public IInputModification makeModification(IInput input) {
        if (input instanceof NumericInput) {
            final NumericInputModification previousModification = new NumericInputModification(((NumericInput) input).getValue().orElse(null));
            if (value != null) {
                ((NumericInput) input).setValue(value);
            }
            return previousModification;
        }
        return new NumericInputModification(null);
    }
}
