package ar.fiuba.tdd.grupo04.inputs;

import ar.fiuba.tdd.grupo04.board.Coordinate;

import java.util.Optional;

public class DiagonalInput extends IInput {
    private Boolean downLeftToUpRight;
    private Boolean marked;
    private Boolean isDiagonal;

    /**
     las dos coord impares son los centros de la celdas(las diagonales) (todos tienen que
     estar marcados true o false para estar completo el tablero)
     las dos coord pares son los puntos del borde de la celda (estan todos en true)
     los que tienen una coorc impar y una par son las aristas de la celda (estan todos en true)
     */
    public DiagonalInput(Coordinate coordinate) {
        this.marked = true;
        this.downLeftToUpRight = false;
        this.isDiagonal = false;
        if ((coordinate.column() & 1) != 0 && (coordinate.row() & 1) != 0) {
            this.marked = false;
            this.isDiagonal = true;
        }
        this.coordinate = coordinate;
    }

    public Boolean isMarked() {
        return marked;
    }

    public Boolean isDiagonal() {
        return isDiagonal;
    }

    public Boolean isDownLeftToUpRight() {
        return downLeftToUpRight;
    }

    public void toogleMarked() {
        marked = !marked;
    }

    public void toogleDirection() {
        downLeftToUpRight = !downLeftToUpRight;
    }

    @Override
    public boolean isFilled() {
        return marked;
    }
}
