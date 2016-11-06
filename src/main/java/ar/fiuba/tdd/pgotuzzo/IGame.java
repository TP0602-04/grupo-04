package ar.fiuba.tdd.pgotuzzo;

import ar.fiuba.tdd.pgotuzzo.board.Slot;

import java.util.List;

public interface IGame {

    void loadScenario(List<Input> initialValues, List<Slot> slots);

    void play(Input input);

    boolean hasWin();

    boolean hasLose();

    String printBoard();

}
