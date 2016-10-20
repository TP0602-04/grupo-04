package ar.fiuba.tdd.grupo04.gui.cell;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.gui.OnClickListener;
import ar.fiuba.tdd.grupo04.gui.View;
import ar.fiuba.tdd.grupo04.gui.exception.IllegalInputException;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public abstract class CellView implements View {
    private static final int BORDER_WIDTH_PX = 1;

    private Coordinate coordinate;
    protected JPanel view;
    protected Set<OnClickListener> listeners;
    private int borderTop;
    private int borderBottom;
    private int borderLeft;
    private int borderRight;

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

    /*
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

    /*
     * Public methods
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void addOnClickListener(OnClickListener listener) {
        listeners.add(listener);
    }

    public void addBorders(boolean top, boolean bottom, boolean left, boolean right) {
        borderTop = top ? BORDER_WIDTH_PX : borderTop;
        borderBottom = bottom ? BORDER_WIDTH_PX : borderBottom;
        borderLeft = left ? BORDER_WIDTH_PX : borderLeft;
        borderRight = right ? BORDER_WIDTH_PX : borderRight;
        view.setBorder(BorderFactory.createMatteBorder(borderTop, borderLeft, borderBottom, borderRight, Color.BLACK));
    }

    /*
     * Abstract methods
     */
    abstract public void setValue(String value) throws IllegalInputException;
}
