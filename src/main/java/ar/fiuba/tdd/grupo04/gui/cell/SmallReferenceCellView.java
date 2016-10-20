package ar.fiuba.tdd.grupo04.gui.cell;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.gui.exception.IllegalInputException;

import javax.swing.*;
import java.awt.*;

public class SmallReferenceCellView extends CellView {
    private JLabel input;

    public SmallReferenceCellView(Coordinate coordinate, String referenceValue) {
        super(coordinate);
        JLabel input = new JLabel();
        view.add(input);
        JLabel label = new JLabel();
        label.setText(referenceValue);
        label.setPreferredSize(new Dimension(10, 10));
        view.add(label);
    }

    @Override
    public void setValue(String value) throws IllegalInputException {

    }

}
