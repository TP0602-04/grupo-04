package ar.fiuba.tdd.grupo04.model.inputs;

public class DiagonalInputModification implements IInputModification {
    private Boolean changeMarked;
    private Boolean changeDiagonalDirection;

    public DiagonalInputModification(Boolean changeMarked, Boolean changeDiagonalDirection) {
        this.changeMarked = changeMarked;
        this.changeDiagonalDirection = changeDiagonalDirection;
    }

    @Override
    public IInputModification makeModification(IInput input) {
        if (input instanceof DiagonalInput) {
            if (changeMarked) {
                ((DiagonalInput)input).toogleMarked();
            }
            if (changeDiagonalDirection) {
                ((DiagonalInput)input).toogleDirection();
            }
        }
        return new DiagonalInputModification(changeMarked, changeDiagonalDirection);
    }
}
