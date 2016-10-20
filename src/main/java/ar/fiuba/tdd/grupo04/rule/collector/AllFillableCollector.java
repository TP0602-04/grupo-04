package ar.fiuba.tdd.grupo04.rule.collector;

import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.IInput;
import ar.fiuba.tdd.grupo04.rule.IInputGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AllFillableCollector<T> implements ICollector {
    private AllCollector<T> allCollector;

    public AllFillableCollector(Board<T> board, Integer value) {
        allCollector = new AllCollector<T>(board, value);
    }

    public AllFillableCollector(Board<T> board) {
        allCollector = new AllCollector<T>(board);
    }

    @Override
    public List getInputGroups() {
        List newInputGroups = new ArrayList<>();
        final List<IInputGroup> inputGroups = allCollector.getInputGroups();
        inputGroups.forEach((IInputGroup inputGroup) -> {
           final List<IInput> inputs = inputGroup.getInputs();
           newInputGroups.add(inputs.stream().filter(IInput::isBlocked).collect(Collectors.toList())); });
        return newInputGroups;
    }
}
