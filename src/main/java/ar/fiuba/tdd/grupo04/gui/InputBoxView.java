package ar.fiuba.tdd.grupo04.gui;

import ar.fiuba.tdd.grupo04.board.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class InputBoxView implements View {
    private JPanel view;
    private JLabel selectionText;
    private JTextField inputText;
    private Coordinate selection;
    private Set<SubmitListener> listeners;
    public InputBoxView() {
        listeners = new HashSet<>();

        view = new JPanel();
        view.setLayout(new GridBagLayout());

        JLabel selectionTitle = new JLabel();
        selectionTitle.setText("SELECTED CELL");
        selectionTitle.setHorizontalAlignment(SwingConstants.CENTER);
        selectionTitle.setBorder(BorderFactory.createDashedBorder(Color.GREEN));
        view.add(selectionTitle, createConstraints(0, 0, 1, 1));

        selectionText = new JLabel();
        selectionText.setHorizontalAlignment(SwingConstants.CENTER);
        selectionText.setBorder(BorderFactory.createDashedBorder(Color.YELLOW));
        view.add(selectionText, createConstraints(0, 1, 1, 1));

        JLabel inputTitle = new JLabel();
        inputTitle.setText("ENTER A VALUE");
        inputTitle.setHorizontalAlignment(SwingConstants.CENTER);
        inputTitle.setBorder(BorderFactory.createDashedBorder(Color.RED));
        view.add(inputTitle, createConstraints(1, 0, 1, 1));

        inputText = new JTextField();
        inputText.setHorizontalAlignment(SwingConstants.CENTER);
        inputText.setBorder(BorderFactory.createDashedBorder(Color.ORANGE));
        view.add(inputText, createConstraints(1, 1, 0.5f, 1));

        JButton button = new JButton();
        button.setText("SUBMIT");
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setBorder(BorderFactory.createDashedBorder(Color.MAGENTA));
        button.addActionListener(e -> submit());
        view.add(button, createConstraints(2, 1, 0.5f, 1));
    }

    private GridBagConstraints createConstraints(int gridX, int gridY, float weightX, float weightY) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        constraints.weightx = weightX;
        constraints.weighty = weightY;
        return constraints;
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
    public void select(Coordinate coordinate) {
        selection = coordinate;
        selectionText.setText("(" + selection.row() + ", " + selection.column() + ")");
    }

    public void addListener(SubmitListener listener) {
        listeners.add(listener);
    }

    /*
     * Private methods
     */
    private void submit() {
        if (selection == null) {
            // TODO - SHOW ERROR
            return;
        }
        if (!listeners.isEmpty()) {
            for (SubmitListener listener : listeners) {
                listener.onSubmit(selection, inputText.getText());
            }
        }
    }

    public interface SubmitListener {
        void onSubmit(Coordinate coordinate, String input);
    }

}
