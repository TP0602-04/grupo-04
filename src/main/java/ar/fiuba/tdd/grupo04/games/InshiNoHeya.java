package ar.fiuba.tdd.grupo04.games;

import ar.fiuba.tdd.grupo04.Game;
import ar.fiuba.tdd.grupo04.IGame;
import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.reference.builder.ReferencedBlockGroupBuilder;
import ar.fiuba.tdd.grupo04.rule.Rule;
import ar.fiuba.tdd.grupo04.rule.collector.ColumnsCollector;
import ar.fiuba.tdd.grupo04.rule.collector.CustomGroupCollector;
import ar.fiuba.tdd.grupo04.rule.condition.UniqueCondition;

public class InshiNoHeya {
//    IGame game;
//    private Board board;
//    private CustomGroupCollector customGroupCollector;
//
//    @SuppressWarnings("CPD-START")
//    public InshiNoHeya() {
//        createGame();
//        createBoard();
//    }
//
//    private void createGame() {
//
//        game = new Game();
//        // Esto se levanta del json de juego
//        board = new Board(5, 5);
//        game.setBoard(board);
//        customGroupCollector = new CustomGroupCollector<>(board);
//        game.addRule(new Rule<>(new ColumnsCollector(board), new UniqueCondition()));
////        game.addRule(new Rule<>(new RowsCollector(board), new UniqueCondition()));
////        game.addRule(new Rule<>(customGroupCollector, new MultiplyCondition()));
//    }
//
//    private void createBoard() {
//        game.fillCell(new Coordinate(1, 1), 1);
//        game.fillCell(new Coordinate(3, 1), 2);
//        game.fillCell(new Coordinate(5, 1), 4);
//        // Aca van todos los grupos que suman numeros;
//        // Esto se levanta del json de escenario
//        final ReferencedBlockGroupBuilder referenceBuilder = new ReferencedBlockGroupBuilder();
//        customGroupCollector.addReferencedGroup(
//                referenceBuilder
//                        .rowOffset(1)
//                        .columnOffset(1)
//                        .columnLarge(2)
//                        .referencedValue(3)
//                        .createReference()
//        );
//        customGroupCollector.addReferencedGroup(
//                referenceBuilder
//                        .rowOffset(1)
//                        .columnOffset(1)
//                        .rowLarge(3)
//                        .referencedValue(7)
//                        .createReference()
//        );
//    }
//
//    public void playGame() {
//        // aca estaria el loop con el input
//        // fillCell tendria q fijarse q no esta puesto ya o algo asi
//        System.out.print(game.checkRules());
//        while (game.checkRules()) {
//            game.fillCell(new Coordinate(2, 7), 8);
//        }
//    }
}
