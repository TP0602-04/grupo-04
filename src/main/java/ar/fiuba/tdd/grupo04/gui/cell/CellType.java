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

    public static CellType fromString(final String s) {
        switch (s) {
            case "number":
                return DYNAMIC_NUMBER;
            default:
                return STATIC_EMPTY;
        }
    }
}
