package ar.fiuba.tdd.grupo04;

import ar.fiuba.tdd.grupo04.board.Slot;

import java.util.List;

public interface IGame {

    void loadStructure(List<Input> structure);

    void loadScenario(List<Input> initialValues, List<Slot> slots);

    void play(Input input);

    boolean hasWin();

    boolean hasLose();

    String printBoard();

}
