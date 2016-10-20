package ar.fiuba.tdd.grupo04.gui.cell;

public enum CellType {
    // static - not editable
    STATIC_EMPTY,
    STATIC_MULTIVALUED,

    // dynamic - editable
    DYNAMIC_NUMBER,
    DYNAMIC_VERTICAL_CONNECTOR,
    DYNAMIC_HORIZONTAL_CONNECTOR,
    DYNAMIC_DIAGONAL_CONNECTOR;

    public static CellType fromString(final String string) {
        switch (string) {
            case "number":
                return DYNAMIC_NUMBER;
            case "multivalued":
                return STATIC_MULTIVALUED;
            case "empty":
                return STATIC_EMPTY;
            default:
                throw new RuntimeException("INVALID CELL TYPE!!!");
        }
    }
}
