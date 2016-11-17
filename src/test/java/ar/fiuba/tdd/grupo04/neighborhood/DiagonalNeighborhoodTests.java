package ar.fiuba.tdd.grupo04.neighborhood;

import ar.fiuba.tdd.grupo04.Coordinate;
import ar.fiuba.tdd.grupo04.board.Cell;
import ar.fiuba.tdd.grupo04.generator.CoordinateGenerator;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class DiagonalNeighborhoodTests {
    private DiagonalNeighborhood neighborhood;
    private Cell dotCell;
    private Coordinate dotCoordinate;

    @Before
    public void initTest() {
        neighborhood = new DiagonalNeighborhood();
        dotCoordinate = CoordinateGenerator.getCoordinate(1, 100);
        dotCell = new Cell(dotCoordinate, DiagonalNeighborhood.DOT);
    }

    @Test
    public void testAreNeighborSuccess_1() {
        Coordinate coordinate = new Coordinate(
                dotCoordinate.row() - 1,
                dotCoordinate.column() - 1
        );
        Cell cell = new Cell(coordinate, DiagonalNeighborhood.DIAGONAL_LEFT_ABOVE_TO_RIGHT_BELOW);
        assertTrue(neighborhood.areNeighbors(cell, dotCell));
    }

    @Test
    public void testAreNeighborSuccess_2() {
        Coordinate coordinate = new Coordinate(
                dotCoordinate.row() + 1,
                dotCoordinate.column() + 1
        );
        Cell cell = new Cell(coordinate, DiagonalNeighborhood.DIAGONAL_LEFT_ABOVE_TO_RIGHT_BELOW);
        assertTrue(neighborhood.areNeighbors(cell, dotCell));
    }

    @Test
    public void testAreNeighborSuccess_3() {
        Coordinate coordinate = new Coordinate(
                dotCoordinate.row() + 1,
                dotCoordinate.column() - 1
        );
        Cell cell = new Cell(coordinate, DiagonalNeighborhood.DIAGONAL_LEFT_BELOW_TO_RIGHT_ABOVE);
        assertTrue(neighborhood.areNeighbors(cell, dotCell));
    }

    @Test
    public void testAreNeighborSuccess_4() {
        Coordinate coordinate = new Coordinate(
                dotCoordinate.row() - 1,
                dotCoordinate.column() + 1
        );
        Cell cell = new Cell(coordinate, DiagonalNeighborhood.DIAGONAL_LEFT_BELOW_TO_RIGHT_ABOVE);
        assertTrue(neighborhood.areNeighbors(cell, dotCell));
    }

    @Test
    public void testAreNeighborFailure_1() {
        Coordinate coordinate = new Coordinate(
                dotCoordinate.row() - 1,
                dotCoordinate.column() - 1
        );
        Cell cell = new Cell(coordinate, DiagonalNeighborhood.DIAGONAL_LEFT_BELOW_TO_RIGHT_ABOVE);
        assertFalse(neighborhood.areNeighbors(cell, dotCell));
    }

    @Test
    public void testAreNeighborFailure_2() {
        Coordinate coordinate = new Coordinate(
                dotCoordinate.row() + 1,
                dotCoordinate.column() + 1
        );
        Cell cell = new Cell(coordinate, DiagonalNeighborhood.DIAGONAL_LEFT_BELOW_TO_RIGHT_ABOVE);
        assertFalse(neighborhood.areNeighbors(cell, dotCell));
    }

    @Test
    public void testAreNeighborFailure_3() {
        Coordinate coordinate = new Coordinate(
                dotCoordinate.row() + 1,
                dotCoordinate.column() - 1
        );
        Cell cell = new Cell(coordinate, DiagonalNeighborhood.DIAGONAL_LEFT_ABOVE_TO_RIGHT_BELOW);
        assertFalse(neighborhood.areNeighbors(cell, dotCell));
    }

    @Test
    public void testAreNeighborFailure_4() {
        Coordinate coordinate = new Coordinate(
                dotCoordinate.row() - 1,
                dotCoordinate.column() + 1
        );
        Cell cell = new Cell(coordinate, DiagonalNeighborhood.DIAGONAL_LEFT_ABOVE_TO_RIGHT_BELOW);
        assertFalse(neighborhood.areNeighbors(cell, dotCell));
    }

}
