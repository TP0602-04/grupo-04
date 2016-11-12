package ar.fiuba.tdd.grupo04.model.inputs;

public class BooleanInputModification implements IInputModification {
    @Override
    public IInputModification makeModification(IInput input) {
        if (input instanceof BooleanInput) {
            ((BooleanInput)input).toogleState();
        }
        return new BooleanInputModification();
    }
}
