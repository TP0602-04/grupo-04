package ar.fiuba.tdd.grupo04.rule.condition;

import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.neighborhood.Neighborhood;
import ar.fiuba.tdd.grupo04.rule.CellGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SlotsOfSizeCondition extends Condition implements ICondition {
    private Neighborhood neighborhood;
    private int expectedSlotSize;

    public SlotsOfSizeCondition(Neighborhood neighborhood, int slotSize) {
        this.neighborhood = neighborhood;
        expectedSlotSize = slotSize;
    }

    @Override
    protected String getConditionName() {
        return SlotsOfSizeCondition.class.getSimpleName();
    }

    @Override
    public boolean check(CellGroup cellGroup) {
        List<Cell> cells = cellGroup.getCells();
        List<List<Cell>> slots = findSlots(cells);

        return slots.stream()
                .map(this::checkSlotSize)
                .reduce(true, (b1, b2) -> b1 && b2);
    }

    private boolean checkSlotSize(List<Cell> cells) {
        boolean check = cells.size() == expectedSlotSize;
        if (!check) {
            printError(cells);
        }
        return check;
    }

    private List<List<Cell>> findSlots(List<Cell> cells) {
        List<List<Cell>> slots = new ArrayList<>();
        if (!cells.isEmpty()) {
            slots = findSlots(slots, cells);
        }
        return slots;
    }

    private List<List<Cell>> findSlots(List<List<Cell>> slots, List<Cell> cells) {
        // Exit condition
        if (cells.isEmpty()) {
            return slots;
        }
        List<Cell> slot = findOneSlot(cells);
        cells.removeAll(slot);
        slots.add(slot);
        return findSlots(slots, cells);
    }

    private List<Cell> findOneSlot(List<Cell> cells) {
        List<Cell> slot = new ArrayList<>();
        if (!cells.isEmpty()) {
            Cell root = cells.get(0);
            cells.remove(root);
            slot.add(root);
            slot = findOneSlot(slot, cells);
        }
        return slot;
    }

    private List<Cell> findOneSlot(List<Cell> slot, List<Cell> cells) {
        // Look for new neighbors
        List<Cell> neighbors =
                slot.stream()
                        .map(cell -> neighborhood.getNeighbors(cell, cells))
                        .reduce(new ArrayList<>(), this::mergeCellLists);
        // Exit condition
        if (neighbors.isEmpty()) {
            return slot;
        }
        // Add neighbors to the current slot
        slot.addAll(neighbors);
        // Remove slot from cells
        List<Cell> pendingCells =
                cells.stream()
                        .filter(cell -> !slot.contains(cell))
                        .collect(Collectors.toList());
        return findOneSlot(slot, pendingCells);
    }

    private List<Cell> mergeCellLists(List<Cell> list1, List<Cell> list2) {
        List<Cell> mergedList = new ArrayList<>();
        mergedList.addAll(list1);
        list2.forEach(
                cell -> {
                    if (!mergedList.contains(cell)) {
                        mergedList.add(cell);
                    }
                }
        );
        return mergedList;
    }

}
