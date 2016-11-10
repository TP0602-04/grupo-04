package ar.fiuba.tdd.grupo04.games;

import ar.fiuba.tdd.grupo04.model.Game;
import ar.fiuba.tdd.grupo04.model.IGame;
import ar.fiuba.tdd.grupo04.model.board.Board;
import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.board.IBoard;
import ar.fiuba.tdd.grupo04.model.board.reference.builder.ReferencedBlockGroupBuilder;
import ar.fiuba.tdd.grupo04.model.inputs.DiagonalInput;
import ar.fiuba.tdd.grupo04.model.inputs.factories.DiagonalInputFactory;
import ar.fiuba.tdd.grupo04.model.rule.Rule;
import ar.fiuba.tdd.grupo04.model.rule.collector.AllCollector;
import ar.fiuba.tdd.grupo04.model.rule.collector.CustomGroupCollector;
import ar.fiuba.tdd.grupo04.model.rule.condition.AllFilledCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.CountDiagonalBiggerCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.CountDiagonalEqualCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.NoLoopsCondition;

@SuppressWarnings("CPD-START")
public class GokigenNaname {
    IGame<DiagonalInput> game;
    private IBoard<DiagonalInput> board;
    private CustomGroupCollector customGroupCollector;

    public GokigenNaname() {
        createGame();
        createBoard();
    }

    private void createGame() {
        game = new Game();
        board = new Board<DiagonalInput>(18, 18, new DiagonalInputFactory());

        game.setBoard(board);
        customGroupCollector = new CustomGroupCollector(board);

        game.addWinRule(new Rule<>(customGroupCollector, new CountDiagonalEqualCondition()));
        game.addLoseRule(new Rule<>(customGroupCollector, new CountDiagonalBiggerCondition()));
        game.addWinRule(new Rule<>(new AllCollector(board), new AllFilledCondition()));
        game.addWinRule(new Rule<>(new AllCollector(board), new NoLoopsCondition()));
    }

    private void createBoard() {
        game.getCell(new Coordinate(1, 1)).toogleMarked();
        game.getCell(new Coordinate(3, 1)).toogleMarked();
        game.getCell(new Coordinate(3, 1)).toogleDirection();
        game.getCell(new Coordinate(5, 1)).toogleMarked();
        game.getCell(new Coordinate(3, 1)).toogleDirection();
        // Aca van todos los grupos que suman numeros;
        // Esto se levanta del json de escenario
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
        // fillCell seria un toogle q pone la diagonal para un lado o para el otro segun true o false
        while (game.checkWinRules()) {
            game.getCell(new Coordinate(3, 7)).toogleMarked();
        }
    }
}
