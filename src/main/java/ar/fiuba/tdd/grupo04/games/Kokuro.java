package ar.fiuba.tdd.grupo04.games;

import ar.fiuba.tdd.grupo04.model.Game;
import ar.fiuba.tdd.grupo04.model.IGame;
import ar.fiuba.tdd.grupo04.model.board.Board;
import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.board.IBoard;
import ar.fiuba.tdd.grupo04.model.board.reference.builder.ReferencedBlockGroupBuilder;
import ar.fiuba.tdd.grupo04.model.inputs.NumericInput;
import ar.fiuba.tdd.grupo04.model.inputs.factories.NumericInputFactory;
import ar.fiuba.tdd.grupo04.model.rule.Rule;
import ar.fiuba.tdd.grupo04.model.rule.collector.AllCollector;
import ar.fiuba.tdd.grupo04.model.rule.collector.CustomGroupCollector;
import ar.fiuba.tdd.grupo04.model.rule.condition.AllFilledCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.AllGreaterThanCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.AllLesserThanCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.SumCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.UniqueCondition;

@SuppressWarnings("CPD-START")
public class Kokuro {
    IGame<NumericInput> game;
    private IBoard<NumericInput> board;
    private CustomGroupCollector customGroupCollector;

    public Kokuro() {
        createGame();
        createBoard();
    }

    private void createGame() {
        game = new Game<>();
        // Esto se levanta del json de juego
        board = new Board<>(9, 9, new NumericInputFactory());
        game.setBoard(board);
        customGroupCollector = new CustomGroupCollector(board);
        game.addLoseRule(new Rule(customGroupCollector, new UniqueCondition()));
        game.addLoseRule(new Rule(customGroupCollector, new SumCondition()));
        game.addLoseRule(new Rule(new AllCollector(board, 10), new AllLesserThanCondition()));
        game.addLoseRule(new Rule(new AllCollector(board, 0), new AllGreaterThanCondition()));
        game.addWinRule(new Rule(customGroupCollector, new AllFilledCondition()));
    }

    private void createBoard() {
        // Esto se levanta del json de escenario
        // Aca va si hay valores iniciales
        game.getCell(new Coordinate(1, 1)).setValue(1);
        game.getCell(new Coordinate(3, 1)).setValue(2);
        game.getCell(new Coordinate(5, 1)).setValue(4);
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
            game.getCell(new Coordinate(2, 7)).setValue(8);
        }
    }
}
