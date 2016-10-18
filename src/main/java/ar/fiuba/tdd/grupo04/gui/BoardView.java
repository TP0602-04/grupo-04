package ar.fiuba.tdd.grupo04.gui;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.gui.cell.CellType;
import ar.fiuba.tdd.grupo04.gui.cell.CellView;
import ar.fiuba.tdd.grupo04.gui.cell.CellViewFactory;
import com.sun.tools.javac.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * N x N Board
 */
public class BoardView implements View {
    private List<List<CellView>> cells;
    private JPanel view;

    public static class Builder {
        private int size = 3;
        private List<List<CellView>> cells;

        public Builder() {
        }

        public Builder setSize(int size) {
            this.size = size;
            cells = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                cells.add(new ArrayList<>());
            }
            return this;
        }

        public Builder setDefaultCellType(CellType defaultCellType) {
            for (int i = 0; i < size; i++) {
                List<CellView> row = cells.get(i);
                for (int j = 0; j < size; j++) {
                    CellView cell = CellViewFactory.create(defaultCellType);
                    row.add(cell);
                }
            }
            return this;
        }

        public Builder setCellType(CellType cellType, List<Pair<Coordinate, String>> cellsData) {
            for (Pair<Coordinate, String> data : cellsData) {
                Coordinate coordinate = data.fst;
                String value = data.snd;
                // Create view
                CellView cellView = CellViewFactory.create(cellType);
                cellView.setValue(value);

                List<CellView> row = cells.get(coordinate.row());
                row.set(coordinate.column(), cellView);
            }
            return this;
        }

        public BoardView build() {
            return new BoardView(size, cells);
        }
    }

    private BoardView(int size, List<List<CellView>> cells) {
        // Main container
        view = new JPanel();
        view.setLayout(new GridLayout(size, size));
        // Cells
        this.cells = cells;
        for (int i = 0; i < size; i++) {
            List<CellView> row = cells.get(i);
            for (int j = 0; j < size; j++) {
                CellView cellView = row.get(j);
                view.add(cellView.getContent());
            }
            cells.add(row);
        }
    }

    @Override
    public void draw() {
        view.updateUI();
    }

    @Override
    public JPanel getContent() {
        return view;
    }

    public void setCellValue(Coordinate coordinate, String value) {
        List<CellView> row = cells.get(coordinate.row());
        CellView view = row.get(coordinate.column());
        view.setValue(value);
    }

}
