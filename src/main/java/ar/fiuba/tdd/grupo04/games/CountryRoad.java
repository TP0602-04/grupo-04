package ar.fiuba.tdd.grupo04.games;

import ar.fiuba.tdd.grupo04.Game;
import ar.fiuba.tdd.grupo04.IGame;
import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.reference.builder.ReferencedBlockGroupBuilder;
import ar.fiuba.tdd.grupo04.rule.collector.CustomGroupCollector;

@SuppressWarnings("CPD-START")
public class CountryRoad {
    IGame game;
    private Board board;
    private CustomGroupCollector customGroupCollector;

    public CountryRoad() {
        createGame();
        createBoard();
    }

    private void createGame() {
        game = new Game();
        // Esto se levanta del json de juego
        // los pares son los centros de la celdas
        // los impares son los segmentos que puede unir
        board = new Board(18, 18, Boolean.valueOf(false));
        game.setBoard(board);
        customGroupCollector = new CustomGroupCollector<>(board);
//        game.addRule(new Rule<>(customGroupCollector, new HasOneCondition()));
//        game.addRule(new Rule<>(customGroupCollector, new CountCondition()));
//        game.addRule(new Rule<>(new AllCollector<>(board), new OneLoopCondition()));
//        game.addRule(new Rule<>(customGroupCollector, new EmptyContiguousInGroupCondition()));
    }

    private void createBoard() {
        game.fillCell(new Coordinate(1, 1), 1);
        game.fillCell(new Coordinate(3, 1), 2);
        game.fillCell(new Coordinate(5, 1), 4);
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
        // entonces pone en true (0,0), (0,1) y (0,2)
        //caso2
        // el jugador quieren unir (7,3) con (6,3)
        // entonces pone en true (14,6), (13,6) y (12,6)
        //caso generico en x
        // el jugador quieren unir punto1=(x,y) con punto2=(x+1,y)
        // entonces pone en true punto1=(2x,2y), punto2=(2(x+1),2y) son las celdas y (2x+1,2y) es la trama q las une
        System.out.print(game.checkRules());
        while (game.checkRules()) {
            game.fillCell(new Coordinate(2, 7), 8);
        }
    }
}
