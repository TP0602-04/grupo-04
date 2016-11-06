package ar.fiuba.tdd.grupo04.gui.cell;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.gui.exception.IllegalInputException;

import java.awt.*;
import javax.swing.*;

public class MultivaluedCellView extends CellView {
    private JLabel label;

    public MultivaluedCellView(Coordinate coordinate) {
        super(coordinate);
        view.setBackground(new Color(0, 255, 255, 50));
        view.setBorder(BorderFactory.createDashedBorder(Color.blue));
        label = new JLabel();
        view.add(label);
    }

    @Override
    public void setValue(String value) throws IllegalInputException {
        label.setText(value);
    }
}
