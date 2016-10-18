package ar.fiuba.tdd.grupo04.gui.cell;

import ar.fiuba.tdd.grupo04.gui.exception.IllegalInputException;

import javax.swing.*;
import java.awt.*;

public class NumberCellView extends CellView {
    private static final String ILLEGAL_INPUT_ERROR_MSG = "Number between 0 and 9 expected";

    private JLabel label;

    public NumberCellView() {
        view.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        label = new JLabel();
        view.add(label);
    }

    @Override
    public void setValue(String value) throws IllegalInputException {
        Integer intValue;
        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalInputException(ILLEGAL_INPUT_ERROR_MSG);
        }
        if (intValue < 0 && intValue > 9) {
            throw new IllegalInputException(ILLEGAL_INPUT_ERROR_MSG);
        }
        label.setText(value);
    }

}
