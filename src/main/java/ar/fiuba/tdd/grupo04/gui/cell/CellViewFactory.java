package ar.fiuba.tdd.grupo04.gui.cell;

import ar.fiuba.tdd.grupo04.board.Coordinate;

public class CellViewFactory {

    public static CellView create(CellType type, Coordinate coordinate) {
        CellView cell = new NumberCellView(coordinate);
        switch (type) {
            case STATIC_EMPTY:
                cell = new EmptyCellView(coordinate);
                break;
            case STATIC_MULTIVALUED:
                cell = new MultivaluedCellView(coordinate);
                break;
            case DYNAMIC_NUMBER:
                cell = new NumberCellView(coordinate);
                break;
            case DYNAMIC_VERTICAL_CONNECTOR:
                break;
            case DYNAMIC_HORIZONTAL_CONNECTOR:
                break;
            case DYNAMIC_DIAGONAL_CONNECTOR:
                break;
        }
        return cell;
    }

}
