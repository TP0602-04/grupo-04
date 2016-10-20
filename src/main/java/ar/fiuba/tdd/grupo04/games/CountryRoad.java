package ar.fiuba.tdd.grupo04.games;

import ar.fiuba.tdd.grupo04.Game;
import ar.fiuba.tdd.grupo04.IGame;
import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.board.reference.builder.ReferencedBlockGroupBuilder;
import ar.fiuba.tdd.grupo04.rule.Rule;
import ar.fiuba.tdd.grupo04.rule.collector.AllCollector;
import ar.fiuba.tdd.grupo04.rule.collector.CustomGroupCollector;
import ar.fiuba.tdd.grupo04.rule.condition.AllFilledCondition;
import ar.fiuba.tdd.grupo04.rule.condition.CountCondition;
import ar.fiuba.tdd.grupo04.rule.condition.HasOneCondition;
import ar.fiuba.tdd.grupo04.rule.condition.OneLoopCondition;

import java.util.function.BiFunction;
import java.util.function.Function;

@SuppressWarnings("CPD-START")
public class CountryRoad {
    IGame game;
    private Board<Boolean> board;
    private CustomGroupCollector customGroupCollector;

    public CountryRoad() {
        createGame();
        createBoard();
    }

    private void createGame() {
        game = new Game();
        // Esto se levanta del json de juego
        // las dos coord pares son los centros de la celdas (marcado true si pasa por aca)
        // las dos coord impares son los puntos de interseccion entre cuatro celdas (no se puede pasar por aca)
        // los que tienen una coorc impar y una par son los segmentos que puede unir (uniendo dos pares de coord pares)
        board = new Board<Boolean>(18, 18, Boolean.FALSE);
        game.setBoard(board);
        customGroupCollector = new CustomGroupCollector<>(board);

        // Its a segment (because one coordinate is odd and the other even) and its marked because the value is true
        BiFunction<Coordinate, Boolean, Boolean> isMarkedSegment = (coordinate, value) -> {
            if ((coordinate.column().intValue() & 1) != 0) {
                if ((coordinate.row().intValue() & 1) == 0) {
                    return value;
                }
            } else {
                if ((coordinate.row().intValue() & 1) != 0) {
                    return value;
                }
            }
            return false;
        };
        game.addWinRule(new Rule<>(customGroupCollector, new HasOneCondition(isMarkedSegment)));
        // Only counts the cells (both coordinates are even)
        Function<Coordinate, Boolean> isCell = (coordinate) -> (coordinate.column().intValue() & 1) == 0
                                                                && (coordinate.row().intValue() & 1) == 0;


        game.addWinRule(new Rule<>(customGroupCollector, new CountCondition(isCell, (expected, counted) -> expected == counted)));
        BiFunction<Integer, Integer, Boolean> bigger = (expected, counted) -> expected < counted;
        game.addLoseRule(new Rule<>(customGroupCollector, new CountCondition(isCell, bigger)));
        game.addWinRule(new Rule<>(new AllCollector(board), new OneLoopCondition(isCell)));
        game.addWinRule(new Rule<>(customGroupCollector, new AllFilledCondition()));
//        game.addLoseRule(new Rule<>(customGroupCollector, new EmptyContiguousInGroupCondition()));
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
        // entonces pone en true (0,0), (0,1) column (0,2)
        //caso2
        // el jugador quieren unir (7,3) con (6,3)
        // entonces pone en true (14,6), (13,6) column (12,6)
        //caso generico en row
        // el jugador quieren unir punto1=(row,column) con punto2=(row+1,column)
        // entonces pone en true punto1=(2x,2y), punto2=(2(row+1),2y) son las celdas column (2x+1,2y) es la trama q las une


        while (game.checkWinRules()) {
            game.fillCell(new Coordinate(2, 7), 8);
        }
    }
}
