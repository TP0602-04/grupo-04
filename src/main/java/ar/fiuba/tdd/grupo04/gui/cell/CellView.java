package ar.fiuba.tdd.grupo04.gui.cell;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.gui.OnClickListener;
import ar.fiuba.tdd.grupo04.gui.View;
import ar.fiuba.tdd.grupo04.gui.exception.IllegalInputException;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

public abstract class CellView implements View {
    private Coordinate coordinate;
    protected JPanel view;
    protected Set<OnClickListener> listeners;

    public CellView(Coordinate coordinate) {
        this.coordinate = coordinate;
        listeners = new HashSet<>();
        view = new JPanel();
        view.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent event) {
                if (!listeners.isEmpty()) {
                    for (OnClickListener listener : listeners) {
                        listener.onClick(CellView.this);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent event) {

            }

            @Override
            public void mouseReleased(MouseEvent event) {

            }

            @Override
            public void mouseEntered(MouseEvent event) {

            }

            @Override
            public void mouseExited(MouseEvent event) {

            }

            @Override
            public void mouseDragged(MouseEvent event) {

            }

            @Override
            public void mouseMoved(MouseEvent event) {

            }
        });
    }

    /**
     * {@link View} implementation
     */
    @Override
    public void draw() {
        view.updateUI();
    }

    @Override
    public JPanel getContent() {
        return view;
    }

    /**
     * Public methods
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void addOnClickListener(OnClickListener listener) {
        listeners.add(listener);
    }

    /**
     * Abstract methods
     */
    abstract public void setValue(String value) throws IllegalInputException;
}
