package ar.fiuba.tdd.grupo04.gui.cell;

public class CellViewFactory {
//    private static final String URL = ;
//    private static final String URL = ;
//    private static final String URL = ;
//    private static final String URL = ;
//    private static final String URL = ;

    public static CellView create(CellType type) {
        // FIXME - Initialize correctly
        CellView cell = new NumberCellView();
        switch (type) {
            case STATIC_EMPTY:
                break;
            case STATIC_MULTIVALUED:
                break;
            case DYNAMIC_NUMBER:
                cell = new NumberCellView();
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
