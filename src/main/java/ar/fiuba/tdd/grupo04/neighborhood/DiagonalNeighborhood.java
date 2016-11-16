package ar.fiuba.tdd.grupo04.neighborhood;

import ar.fiuba.tdd.grupo04.board.Cell;

public class DiagonalNeighborhood extends Neighborhood {
    public static final int DOT = 0;
    public static final int DIAGONAL_LEFT_BELOW_TO_RIGHT_ABOVE = 1;
    public static final int DIAGONAL_LEFT_ABOVE_TO_RIGHT_BELOW = 2;

    @Override
    public boolean areNeighbors(Cell cell1, Cell cell2) {
        // First -> Check types: only a diagonal an a dot are going to be potential neighbors
        Cell dotCell = getUniqueCell(DOT, cell1, cell2);
        Cell diagonalCell = getUniqueCell(DIAGONAL_LEFT_BELOW_TO_RIGHT_ABOVE, cell1, cell2);
        if (diagonalCell == null) {
            diagonalCell = getUniqueCell(DIAGONAL_LEFT_ABOVE_TO_RIGHT_BELOW, cell1, cell2);
        }
        if (dotCell == null || diagonalCell == null) {
            return false;
        }
        // Second -> Check positions: vicinity
        int deltaRow = dotCell.getCoordinate().row() - diagonalCell.getCoordinate().row();
        int deltaColumn = dotCell.getCoordinate().column() - diagonalCell.getCoordinate().column();
        if (Math.abs(deltaRow) != 1 && Math.abs(deltaColumn) != 1) {
            return false;
        }
        // Third -> Check diagonal type with position
        if (deltaRow * deltaColumn == 1 &&
                diagonalCell.getValue() == DIAGONAL_LEFT_ABOVE_TO_RIGHT_BELOW) {
            return true;
        }
        if (deltaRow * deltaColumn == -1 &&
                diagonalCell.getValue() == DIAGONAL_LEFT_BELOW_TO_RIGHT_ABOVE) {
            return true;
        }
        return false;
    }

    private Cell getUniqueCell(int value, Cell cell1, Cell cell2) {
        if (cell1.getValue() == value && cell2.getValue() != value) {
            return cell1;
        }
        if (cell2.getValue() == value && cell1.getValue() != value) {
            return cell2;
        }
        return null;
    }

}
