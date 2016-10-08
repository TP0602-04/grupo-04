package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.reference.IReferencedGroup;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;
import ar.fiuba.tdd.grupo04.rule.ValuedInputGroup;

import java.util.ArrayList;
import java.util.List;

public class CustomGroupCollector<T, R extends IValuedInputGroup> implements ICollector<R> {
    private List<IReferencedGroup> referencedBlockGroups;
    private Board<T> board;

    public CustomGroupCollector(Board<T> board) {
        this.board = board;
        referencedBlockGroups = new ArrayList<>();
    }

    public void addReferencedGroup(IReferencedGroup referencedBlockGroup) {
        referencedBlockGroups.add(referencedBlockGroup);
    }

    @Override
    public List<R> getInputGroups() {
        List inputGroups = new ArrayList();
        for (int i = 0; i < referencedBlockGroups.size(); i++) {
            List<T> inputs = new ArrayList<>();
            IReferencedGroup rg = referencedBlockGroups.get(i);
            List<Coordinate> coordinates = rg.getCoordinates();
            for (Coordinate coordinate : coordinates) {
                inputs.add(board.get(coordinate));
            }
            inputGroups.add(new ValuedInputGroup(rg.getValue(), inputs));
        }

        return inputGroups;
    }
}
