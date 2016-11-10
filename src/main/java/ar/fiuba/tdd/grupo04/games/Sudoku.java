//package ar.fiuba.tdd.grupo04.games;
//
//import ar.fiuba.tdd.grupo04.model.Game;
//import ar.fiuba.tdd.grupo04.model.IGame;
//import ar.fiuba.tdd.grupo04.model.board.Board;
//import ar.fiuba.tdd.grupo04.model.board.Coordinate;
//import ar.fiuba.tdd.grupo04.model.inputs.NumericInput;
//import ar.fiuba.tdd.grupo04.model.inputs.factories.NumericInputFactory;
//import ar.fiuba.tdd.grupo04.model.rule.Rule;
//import ar.fiuba.tdd.grupo04.model.rule.collector.AllCollector;
//import ar.fiuba.tdd.grupo04.model.rule.collector.BlocksCollector;
//import ar.fiuba.tdd.grupo04.model.rule.collector.ColumnsCollector;
//import ar.fiuba.tdd.grupo04.model.rule.collector.RowsCollector;
//import ar.fiuba.tdd.grupo04.model.rule.condition.AllFilledCondition;
//import ar.fiuba.tdd.grupo04.model.rule.condition.AllGreaterThanCondition;
//import ar.fiuba.tdd.grupo04.model.rule.condition.AllLesserThanCondition;
//import ar.fiuba.tdd.grupo04.model.rule.condition.UniqueCondition;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//@SuppressWarnings("CPD-START")
//public class Sudoku {
//    IGame<NumericInput> game;
//    private Board<NumericInput> board;
//
//    public Sudoku() {
//        createGame();
//        createBoard();
//    }
//
//    private void createGame() {
//        game = new Game<>();
//        // Esto se levanta del json de juego
//        board = new Board<>(9, 9, new NumericInputFactory());
//        game.setBoard(board);
//        game.addLoseRule(new Rule<>(new ColumnsCollector(board), new UniqueCondition()));
//        game.addLoseRule(new Rule<>(new RowsCollector(board), new UniqueCondition()));
//        game.addLoseRule(new Rule<>(new BlocksCollector(board, 3, 3), new UniqueCondition()));
//        game.addLoseRule(new Rule<>(new AllCollector(board, 10), new AllLesserThanCondition()));
//        game.addLoseRule(new Rule<>(new AllCollector(board, 0), new AllGreaterThanCondition()));
//        game.addWinRule(new Rule<>(new AllCollector(board), new AllFilledCondition()));
//    }
//
//    private void setBoardNCSS1() {
//        game.addInputModification(new Coordinate(0, 3)).setValue(6);
//        game.addInputModification(new Coordinate(0, 4)).setValue(5);
//
//        game.addInputModification(new Coordinate(1, 1)).setValue(7);
//        game.addInputModification(new Coordinate(1, 3)).setValue(3);
//        game.addInputModification(new Coordinate(1, 4)).setValue(8);
//        game.addInputModification(new Coordinate(1, 6)).setValue(2);
//
//        game.addInputModification(new Coordinate(2, 0)).setValue(2);
//        game.addInputModification(new Coordinate(2, 1)).setValue(8);
//        game.addInputModification(new Coordinate(2, 2)).setValue(5);
//        game.addInputModification(new Coordinate(2, 4)).setValue(4);
//
//        game.addInputModification(new Coordinate(4, 0)).setValue(7);
//        game.addInputModification(new Coordinate(4, 2)).setValue(4);
//        game.addInputModification(new Coordinate(4, 3)).setValue(8);
//        game.addInputModification(new Coordinate(4, 4)).setValue(2);
//        game.addInputModification(new Coordinate(4, 5)).setValue(6);
//        game.addInputModification(new Coordinate(4, 6)).setValue(5);
//        game.addInputModification(new Coordinate(4, 7)).setValue(9);
//        game.addInputModification(new Coordinate(4, 8)).setValue(3);
//    }
//
//    private void setBoardNCSS2() {
//        game.addInputModification(new Coordinate(5, 4)).setValue(1);
//        game.addInputModification(new Coordinate(5, 5)).setValue(7);
//        game.addInputModification(new Coordinate(5, 6)).setValue(6);
//        game.addInputModification(new Coordinate(5, 7)).setValue(2);
//        game.addInputModification(new Coordinate(5, 8)).setValue(4);
//
//        game.addInputModification(new Coordinate(6, 0)).setValue(5);
//        game.addInputModification(new Coordinate(6, 5)).setValue(4);
//        game.addInputModification(new Coordinate(6, 8)).setValue(6);
//
//        game.addInputModification(new Coordinate(7, 0)).setValue(3);
//        game.addInputModification(new Coordinate(7, 4)).setValue(6);
//
//        game.addInputModification(new Coordinate(8, 0)).setValue(4);
//        game.addInputModification(new Coordinate(8, 3)).setValue(2);
//        game.addInputModification(new Coordinate(8, 4)).setValue(3);
//        game.addInputModification(new Coordinate(8, 6)).setValue(8);
//    }
//
//    private void createBoard() {
//        setBoardNCSS1();
//        setBoardNCSS2();
//    }
//
//    public void playGame() throws IOException {
//        String input;
//        InputStreamReader isr = new InputStreamReader(System.in, "utf-8");
//        BufferedReader br = new BufferedReader(isr);
//        while (!game.checkWinRules() && !game.checkLoseRules()) {
//            System.out.println("ingrese fila,columna,valor");
//            input = br.readLine();
//            if (!"".equals(input)) {
//                Integer row = Integer.parseInt(input.substring(0, 1)) - 1;
//                Integer col = Integer.parseInt(input.substring(2, 3)) - 1;
//                Integer value = Integer.parseInt(input.substring(4));
//                game.addInputModification(new Coordinate(row, col)).setValue(value);
//            }
//        }
//        if (game.checkWinRules()) {
//            System.out.println("GANASTE");
//        } else {
//            System.out.println("PERDISTE");
//        }
//    }
//}
