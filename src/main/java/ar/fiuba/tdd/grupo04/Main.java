package ar.fiuba.tdd.grupo04;

import ar.fiuba.tdd.grupo04.games.Sudoku;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Sudoku sudoku = new Sudoku();
        sudoku.playGame();
    }
}
