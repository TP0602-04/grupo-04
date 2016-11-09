package ar.fiuba.tdd.grupo04.games;

import ar.fiuba.tdd.grupo04.Game;
import ar.fiuba.tdd.grupo04.IGame;
import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.IBoard;
import ar.fiuba.tdd.grupo04.board.reference.builder.ReferencedBlockGroupBuilder;
import ar.fiuba.tdd.grupo04.inputs.NumericInput;
import ar.fiuba.tdd.grupo04.inputs.factories.NumericInputFactory;
import ar.fiuba.tdd.grupo04.rule.Rule;
import ar.fiuba.tdd.grupo04.rule.collector.AllCollector;
import ar.fiuba.tdd.grupo04.rule.collector.ColumnsCollector;
import ar.fiuba.tdd.grupo04.rule.collector.CustomGroupCollector;
import ar.fiuba.tdd.grupo04.rule.collector.RowsCollector;
import ar.fiuba.tdd.grupo04.rule.condition.AllFilledCondition;
import ar.fiuba.tdd.grupo04.rule.condition.MultiplyCondition;
import ar.fiuba.tdd.grupo04.rule.condition.UniqueCondition;

@SuppressWarnings("CPD-START")
public class InshiNoHeya {
    IGame<NumericInput> game;
    private IBoard<NumericInput> board;
    private CustomGroupCollector customGroupCollector;

    @SuppressWarnings("CPD-START")
    public InshiNoHeya() {
        createGame();
        createBoard();
    }

    private void createGame() {

        game = new Game();
        // Esto se levanta del json de juego
        board = new Board(5, 5, new NumericInputFactory());
        game.setBoard(board);
        customGroupCollector = new CustomGroupCollector(board);
        game.addLoseRule(new Rule<>(new ColumnsCollector(board), new UniqueCondition()));
        game.addLoseRule(new Rule<>(new RowsCollector(board), new UniqueCondition()));
        game.addWinRule(new Rule<>(new AllCollector(board), new AllFilledCondition()));
        game.addWinRule(new Rule<>(customGroupCollector, new MultiplyCondition()));
    }

    private void createBoard() {
        game.getCell(new Coordinate(1, 1)).setValue(1);
        game.getCell(new Coordinate(3, 1)).setValue(2);
        game.getCell(new Coordinate(5, 1)).setValue(4);
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
        // fillCell tendria q fijarse q no esta puesto ya o algo asi
        while (game.checkWinRules()) {
            game.getCell(new Coordinate(2, 7)).setValue(8);
        }
    }
}
