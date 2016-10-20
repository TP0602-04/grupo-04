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
import ar.fiuba.tdd.grupo04.rule.condition.CountBiCondition;

import java.util.function.BiFunction;

@SuppressWarnings("CPD-START")
public class GokigenNaname {
    IGame game;
    private Board<Boolean> board;
    private CustomGroupCollector customGroupCollector;

    public GokigenNaname() {
        createGame();
        createBoard();
    }

    private void createGame() {
        game = new Game();
        /*
            Esto se levanta del json de juego
            Si el campo esta en true significa que la diagonal va de abajo a la izquierda a arriba a la derecha,
            si es false de abajo a la derecha a arriba a la izquierda
            las dos coord impares son los centros de la celdas(las diagonales) (todos tienen que
            estar marcados true o false para estar completo el tablero)
            las dos coord pares son los puntos del borde de la celda (estan todos en true)
            los que tienen una coorc impar y una par son las aristas de la celda (estan todos en true)
         */
        board = new Board<Boolean>(18, 18, Boolean.FALSE);
        for (int i = 1; i < 18; i = i + 2) {
            for (int j = 1; j < 18; j = j + 2) {
                board.put(null, new Coordinate(i, j));
            }
        }

        game.setBoard(board);
        customGroupCollector = new CustomGroupCollector<>(board);

        // Dice si tiene si la diagonal tiene que ir de abajo a la izquierda a arriba a la derecha o viceversa segun
        // las coordenadas
        BiFunction<ValuedCoordinate, Coordinate, Boolean> whichDiagonal = (valuedCoordinate, coordinate) -> {
            //TODO: No se porque checkstyle me tira que estas lineas deben estar una indentacion mas
            final Coordinate difference = valuedCoordinate.getCoordinate().minus(coordinate);
            final int kindOfDiagonal = difference.column() + difference.row();
            // Si la diagonal va de abajo a la izquierda a arriba a la derecha la suma de las coordenadas
            // de la diferencia da cero
            return kindOfDiagonal == 0;
        };

        game.addWinRule(new Rule<>(customGroupCollector, new CountBiCondition(whichDiagonal, (expected, counted) -> expected == counted)));
        BiFunction<Integer, Integer, Boolean> bigger = (expected, counted) -> expected < counted;
        game.addLoseRule(new Rule<>(customGroupCollector, new CountBiCondition(whichDiagonal, bigger)));
        game.addWinRule(new Rule<>(new AllCollector(board), new AllFilledCondition()));
//        game.addWinRule(new Rule<>(new AllCollector(board), new OneLoopLoco()));
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
        // fillCell seria un toogle q pone la diagonal para un lado o para el otro segun true o false
        while (game.checkWinRules()) {
            game.fillCell(new Coordinate(2, 7), 8);
        }
    }
}
