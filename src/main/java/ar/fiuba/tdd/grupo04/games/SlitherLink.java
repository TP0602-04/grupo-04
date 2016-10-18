package ar.fiuba.tdd.grupo04.games;

import ar.fiuba.tdd.grupo04.Game;
import ar.fiuba.tdd.grupo04.IGame;
import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.reference.builder.ReferencedBlockGroupBuilder;
import ar.fiuba.tdd.grupo04.rule.Rule;
import ar.fiuba.tdd.grupo04.rule.collector.AllCollector;
import ar.fiuba.tdd.grupo04.rule.collector.CustomGroupCollector;
import ar.fiuba.tdd.grupo04.rule.condition.CountCondition;
import ar.fiuba.tdd.grupo04.rule.condition.HasOneCondition;
import ar.fiuba.tdd.grupo04.rule.condition.OneLoopCondition;

import java.util.function.BiFunction;
import java.util.function.Function;

@SuppressWarnings("CPD-START")
public class SlitherLink {
    IGame game;
    private Board board;
    private CustomGroupCollector customGroupCollector;

    public SlitherLink() {
        createGame();
        createBoard();
    }

    private void createGame() {
        game = new Game();
        // Esto se levanta del json de juego
        // las dos coord pares son los centros de la celdas (marcado true si pasa por aca)
        // las dos coord impares son los puntos de interseccion entre cuatro celdas (no se puede pasar por aca)
        // los que tienen una coorc impar y una par son los segmentos que puede unir (uniendo dos pares de coord pares)
        board = new Board(18, 18, Boolean.valueOf(false));
        game.setBoard(board);
        customGroupCollector = new CustomGroupCollector<>(board);

        // Only counts segments (one coordinate is odd and the other even)
        Function<Coordinate, Boolean> isSegment = (coordinate) -> {
            if ((coordinate.column().intValue() & 1) != 0) {
                if ((coordinate.row().intValue() & 1) == 0) {
                    return true;
                }
            } else {
                if ((coordinate.row().intValue() & 1) != 0) {
                    return true;
                }
            }
            return false;
        };
        game.addRule(new Rule<>(customGroupCollector, new CountCondition(isSegment)));
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
        // Con esto se checkea si ya gano

        Function<Coordinate, Boolean> isCell = (coordinate) -> (coordinate.column().intValue() & 1) == 0 && (coordinate.row().intValue() & 1) == 0;

        Function<Coordinate, Boolean> isSegment = (coordinate) -> {
            if ((coordinate.column().intValue() & 1) != 0) {
                if ((coordinate.row().intValue() & 1) == 0) {
                    return true;
                }
            } else {
                if ((coordinate.row().intValue() & 1) != 0) {
                    return true;
                }
            }
            return false;
        };
        new Rule<>(new AllCollector<>(board), new OneLoopCondition(isCell, isSegment));
        while (game.checkRules()) {
            game.fillCell(new Coordinate(2, 7), 8);
        }
    }
}