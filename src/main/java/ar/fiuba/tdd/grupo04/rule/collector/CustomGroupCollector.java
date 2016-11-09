package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.board.reference.IReferencedGroup;
import ar.fiuba.tdd.grupo04.inputs.IInput;
import ar.fiuba.tdd.grupo04.rule.IValuedInputGroup;
import ar.fiuba.tdd.grupo04.rule.ValuedInputGroup;

import java.util.ArrayList;
import java.util.List;

public class CustomGroupCollector implements ICollector {
    private List<IReferencedGroup<IValuedInputGroup>> referencedBlockGroups;
    private IBoard board;

    public CustomGroupCollector(IBoard board) {
        this.board = board;
        referencedBlockGroups = new ArrayList<>();
    }

    public void addReferencedGroup(IReferencedGroup referencedBlockGroup) {
        referencedBlockGroups.add(referencedBlockGroup);
    }

    @Override
    public List<ValuedInputGroup> getInputGroups() {
        List<ValuedInputGroup> inputGroups = new ArrayList<>();
        for (IReferencedGroup<IValuedInputGroup> referencedBlockGroup : referencedBlockGroups) {
            List<IInput> inputs = new ArrayList<>();
            List<Coordinate> coordinates = referencedBlockGroup.getCoordinates();
            for (Coordinate coordinate : coordinates) {
                inputs.add(board.get(coordinate));
            }
            inputGroups.add(new ValuedInputGroup<>(referencedBlockGroup.getValue(), inputs));
        }

        return inputGroups;
    }
}
