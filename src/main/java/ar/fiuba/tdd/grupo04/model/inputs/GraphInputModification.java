package ar.fiuba.tdd.grupo04.model.inputs;

public class GraphInputModification implements IInputModification {
    @Override
    public IInputModification makeModification(IInput input) {
        if (input instanceof GraphInput) {
            ((GraphInput) input).toogleMarked();
        }
        return new GraphInputModification();
    }
}
