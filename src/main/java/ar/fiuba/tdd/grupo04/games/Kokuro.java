package ar.fiuba.tdd.grupo04.games;

import ar.fiuba.tdd.grupo04.Game;
import ar.fiuba.tdd.grupo04.IGame;
import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.reference.builder.ReferencedBlockGroupBuilder;
import ar.fiuba.tdd.grupo04.rule.Rule;
import ar.fiuba.tdd.grupo04.rule.collector.AllFillableCollector;
import ar.fiuba.tdd.grupo04.rule.collector.CustomGroupCollector;
import ar.fiuba.tdd.grupo04.rule.condition.AllFilledCondition;
import ar.fiuba.tdd.grupo04.rule.condition.AllGreaterThanCondition;
import ar.fiuba.tdd.grupo04.rule.condition.AllLesserThanCondition;
import ar.fiuba.tdd.grupo04.rule.condition.SumCondition;
import ar.fiuba.tdd.grupo04.rule.condition.UniqueCondition;

@SuppressWarnings("CPD-START")
public class Kokuro {
    IGame game;
    private Board board;
    private CustomGroupCollector customGroupCollector;

    public Kokuro() {
        createGame();
        createBoard();
    }

    private void createGame() {

        game = new Game();
        // Esto se levanta del json de juego
        board = new Board(8, 8);
        game.setBoard(board);
        customGroupCollector = new CustomGroupCollector<>(board);
        game.addLoseRule(new Rule<>(customGroupCollector, new UniqueCondition()));
        game.addLoseRule(new Rule<>(customGroupCollector, new SumCondition()));
        game.addLoseRule(new Rule<>(new AllFillableCollector<>(board, 10), new AllLesserThanCondition()));
        game.addLoseRule(new Rule<>(new AllFillableCollector<>(board, 0), new AllGreaterThanCondition()));
        game.addWinRule(new Rule<>(new AllFillableCollector(board), new AllFilledCondition()));
    }

    private void createBoard() {
        // Esto se levanta del json de escenario
        // Aca va si hay valores iniciales
        game.fillCell(new Coordinate(1, 1), 1);
        game.fillCell(new Coordinate(3, 1), 2);
        game.fillCell(new Coordinate(5, 1), 4);
        // Aca van todas las celdas que no se usan
        game.blockCell(new Coordinate(5, 2));
        game.blockCell(new Coordinate(3, 7));
        // Aca van todos los grupos que suman numeros;
        final ReferencedBlockGroupBuilder referenceBuilder = new ReferencedBlockGroupBuilder();
        customGroupCollector.addReferencedGroup(
                referenceBuilder
                        .rowOffset(1)
                        .columnOffset(1)
                        .columnLarge(2)
                        .referencedValue(3)
                        .createReference()
        );
        customGroupCollector.addReferencedGroup(
                referenceBuilder
                        .rowOffset(1)
                        .columnOffset(1)
                        .rowLarge(3)
                        .referencedValue(7)
                        .createReference()
        );
    }

    public void playGame() {
        // aca estaria el loop con el input
        // fillCell tendria q fijarse q no esta puesto ya o algo asi
        while (game.checkWinRules()) {
            game.fillCell(new Coordinate(2, 7), 8);
        }
    }
}
