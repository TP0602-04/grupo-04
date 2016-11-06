package ar.fiuba.tdd.pgotuzzo;

import java.util.List;

public interface IGame {

    void loadScenario(List<Input> initialValues);

    void play(Input input);

    boolean hasWin();

    boolean hasLose();

    String printBoard();

}
