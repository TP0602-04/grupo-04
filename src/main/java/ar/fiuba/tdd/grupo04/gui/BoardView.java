package ar.fiuba.tdd.grupo04.gui;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.gui.cell.CellType;
import ar.fiuba.tdd.grupo04.gui.cell.CellView;
import ar.fiuba.tdd.grupo04.gui.cell.CellViewFactory;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * N row N Board
 */
public class BoardView implements View {
    /*
     * {@link BoardView} implementation
     */
    private static final int CELL_GAP = 1;
    private List<List<CellView>> cells;
    private JPanel view;
    private Set<Observer> observers;
    private BoardView(int size, List<List<CellView>> cells) {
        observers = new HashSet<>();
        // Main container
        view = new JPanel();
        view.setLayout(new GridLayout(size, size, CELL_GAP, CELL_GAP));
        // Cells
        this.cells = cells;
        for (int i = 0; i < size; i++) {
            List<CellView> row = cells.get(i);
            for (int j = 0; j < size; j++) {
                final CellView cellView = row.get(j);
                cellView.addOnClickListener(v -> onCellClicked(cellView));
                view.add(cellView.getContent());
            }
            cells.add(row);
        }
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
    public void setCellValue(Coordinate coordinate, String value) {
        List<CellView> row = cells.get(coordinate.row());
        CellView view = row.get(coordinate.column());
        view.setValue(value);
    }

    public void setPerimeter(List<Coordinate> coordinates) {
        for (Coordinate current : coordinates) {
            boolean left = true;
            boolean right = true;
            boolean top = true;
            boolean bottom = true;
            int row = current.row();
            int column = current.column();
            for (Coordinate aux : coordinates) {
                int auxRow = aux.row();
                int auxColumn = aux.column();
                if (row == auxRow) {
                    if (column > auxColumn) {
                        left = false;
                    } else if (column < auxColumn) {
                        right = false;
                    }
                }
                if (column == auxColumn) {
                    if (row > auxRow) {
                        bottom = false;
                    } else if (row < auxRow) {
                        top = false;
                    }
                }
            }
            cells.get(row).get(column).addBorders(top, bottom, left, right);
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /*
     * Private methods
     */
    private void onCellClicked(CellView cell) {
        if (!observers.isEmpty()) {
            for (Observer observer : observers) {
                observer.onCellSelected(cell.getCoordinate());
            }
        }
    }

    public interface Observer {
        void onCellSelected(Coordinate coordinate);
    }

    /*
     * Builder
     */
    public static class Builder {
        private int size;
        private List<List<CellView>> cells;
        private List<List<Coordinate>> perimeters;

        public Builder(int size, CellType defaultCellType) {
            setSize(size);
            setDefaultCellType(defaultCellType);
            perimeters = new ArrayList<>();
        }

        private Builder setSize(int size) {
            this.size = size;
            cells = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                cells.add(new ArrayList<>());
            }
            return this;
        }

        public Builder setCellType(CellType cellType, List<Pair<Coordinate, String>> cellsData) {
            for (Pair<Coordinate, String> data : cellsData) {
                Coordinate coordinate = data.getKey();
                String value = data.getValue();
                // Create view
                CellView cellView = CellViewFactory.create(cellType, coordinate);
                if (value != null) {
                    cellView.setValue(value);
                }

                List<CellView> row = cells.get(coordinate.row());
                row.set(coordinate.column(), cellView);
            }
            return this;
        }

        public Builder addPerimeter(List<Coordinate> coordinates) {
            perimeters.add(coordinates);
            return this;
        }

        public BoardView build() {
            BoardView boardView = new BoardView(size, cells);
            perimeters.forEach(boardView::setPerimeter);
            return boardView;
        }

        private void setDefaultCellType(CellType defaultCellType) {
            for (int i = 0; i < size; i++) {
                List<CellView> row = cells.get(i);
                for (int j = 0; j < size; j++) {
                    Coordinate coordinate = new Coordinate(i, j);
                    CellView cell = CellViewFactory.create(defaultCellType, coordinate);
                    row.add(cell);
                }
            }
        }
    }

}
