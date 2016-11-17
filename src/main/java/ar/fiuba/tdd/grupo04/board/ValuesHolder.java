package ar.fiuba.tdd.grupo04.board;

import java.util.ArrayList;
import java.util.List;

public class ValuesHolder<T> {
    private List<Integer> values;
    protected List<T> things;

    public ValuesHolder(List<T> things, List<Integer> values) {
        this.values = values;
        this.things = new ArrayList<>();
        this.things.addAll(things);
    }

    public List<Integer> getValues() {
        return values;
    }
}
