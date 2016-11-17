package ar.fiuba.tdd.grupo04.board;

import java.util.List;

public class Reference extends ValuesHolder<Cell> {

    public Reference(List<Cell> cells, List<Integer> referenceValues) {
        super(cells, referenceValues);
    }

    public List<Cell> getCells() {
        return things;
    }

}
