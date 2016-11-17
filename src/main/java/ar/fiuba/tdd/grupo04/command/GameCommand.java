package ar.fiuba.tdd.grupo04.command;

public interface GameCommand {
    void execute();

    void revert();
}
