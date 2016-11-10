package ar.fiuba.tdd.grupo04.games;

import ar.fiuba.tdd.grupo04.model.Game;
import ar.fiuba.tdd.grupo04.model.IGame;
import ar.fiuba.tdd.grupo04.model.board.Board;
import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.board.IBoard;
import ar.fiuba.tdd.grupo04.model.board.reference.builder.ReferencedBlockGroupBuilder;
import ar.fiuba.tdd.grupo04.model.inputs.GraphInput;
import ar.fiuba.tdd.grupo04.model.inputs.factories.GraphInputFactory;
import ar.fiuba.tdd.grupo04.model.rule.Rule;
import ar.fiuba.tdd.grupo04.model.rule.collector.AllCollector;
import ar.fiuba.tdd.grupo04.model.rule.collector.CustomGroupCollector;
import ar.fiuba.tdd.grupo04.model.rule.condition.AllFilledCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.CountEdgesBiggerCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.CountEdgesEqualCondition;
import ar.fiuba.tdd.grupo04.model.rule.condition.OneLoopCondition;

@SuppressWarnings("CPD-START")
public class SlitherLink {
    IGame<GraphInput> game;
    private IBoard<GraphInput> board;
    private CustomGroupCollector customGroupCollector;

    public SlitherLink() {
        createGame();
        createBoard();
    }

    private void createGame() {
        game = new Game();
        // Esto se levanta del json de juego
        // las dos coord pares son los nodos (marcado true si pasa por aca)
        // las dos coord impares son los lugares dnd estan las condiciones o no hay nada(en el dibujito)
        // (no se puede pasar por aca)
        // los que tienen una coorc impar y una par son los segmentos que puede unir (uniendo dos pares de coord pares)
        board = new Board(18, 18, new GraphInputFactory());

        game.setBoard(board);
        customGroupCollector = new CustomGroupCollector(board);
        game.addLoseRule(new Rule<>(customGroupCollector, new CountEdgesBiggerCondition()));
        game.addWinRule(new Rule<>(customGroupCollector, new CountEdgesEqualCondition()));
        game.addWinRule(new Rule<>(new AllCollector(board), new AllFilledCondition()));
        game.addWinRule(new Rule<>(new AllCollector(board), new OneLoopCondition()));
    }

    private void createBoard() {
        game.getCell(new Coordinate(1, 1)).toogleMarked();
        game.getCell(new Coordinate(3, 1)).toogleMarked();
        game.getCell(new Coordinate(5, 1)).toogleMarked();
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
        //caso1
        // el jugador quieren unir (0,0) con (0,1)
        // entonces pone en true (0,0), (0,1) column (0,2)
        //caso2
        // el jugador quieren unir (7,3) con (6,3)
        // entonces pone en true (14,6), (13,6) column (12,6)
        //caso generico en row
        // el jugador quieren unir punto1=(row,column) con punto2=(row+1,column)
        // entonces pone en true punto1=(2x,2y), punto2=(2(row+1),2y) son las celdas column (2x+1,2y) es la trama q las une


        // Con esto se checkea si ya gano

        while (game.checkWinRules()) {
            game.getCell(new Coordinate(2, 7)).toogleMarked();
        }
    }
}
