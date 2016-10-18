package ar.fiuba.tdd.grupo04.gui.cell;

import ar.fiuba.tdd.grupo04.gui.View;
import ar.fiuba.tdd.grupo04.gui.exception.IllegalInputException;

import javax.swing.*;

public abstract class CellView implements View {
    protected JPanel view;

    public CellView() {
        view = new JPanel();
    }

    @Override
    public void draw() {
        view.updateUI();
    }

    @Override
    public JPanel getContent() {
        return view;
    }

    abstract public void setValue(String value) throws IllegalInputException;
}
