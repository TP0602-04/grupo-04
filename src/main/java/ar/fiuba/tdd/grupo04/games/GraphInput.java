package ar.fiuba.tdd.grupo04.games;

@SuppressWarnings("CPD-START")
public class GraphInput {
    private final GraphInputType type;
    private final Boolean marked;

    public GraphInput(GraphInputType type, Boolean marked) {
        this.type = type;
        this.marked = marked;
    }

    public GraphInputType getType() {
        return type;
    }

    public Boolean getMarked() {
        return marked;
    }
}

enum GraphInputType {EDGE, NODE, INVALID_ELEMENT}
