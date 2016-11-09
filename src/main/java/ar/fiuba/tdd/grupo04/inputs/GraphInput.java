package ar.fiuba.tdd.grupo04.inputs;

import ar.fiuba.tdd.grupo04.board.Coordinate;

@SuppressWarnings("CPD-START")
public class GraphInput extends IInput {
    private final GraphInputType type;
    private Boolean marked;

    public GraphInput(Coordinate coordinate) {
        this.marked = false;
        this.coordinate = coordinate;
        if ((coordinate.column() & 1) == 0 && (coordinate.row() & 1) == 0) {
            this.type = GraphInputType.NODE;
        } else if ((coordinate.column() & 1) != 0 && (coordinate.row() & 1) != 0) {
            this.type = GraphInputType.INVALID_ELEMENT;
        } else {
            this.type = GraphInputType.EDGE;
        }
    }

    public GraphInputType getType() {
        return type;
    }

    public Boolean isMarked() {
        return marked;
    }

    public void toogleMarked() {
        marked = !marked;
    }

    @Override
    public boolean isFilled() {
        return marked != null;
    }
}

