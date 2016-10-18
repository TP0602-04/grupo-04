package ar.fiuba.tdd.grupo04.gui;

import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.gui.cell.CellType;
import ar.fiuba.tdd.grupo04.gui.model.*;
import com.google.gson.Gson;
import com.sun.tools.javac.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameGui {
    private static final int WINDOW_WIDTH = 900;
    private static final int WINDOW_HEIGHT = 600;

    private static JFrame frame;
    private static BoardView boardView;

    public static void create(String json) {
        // Game configuration
        Gson gson = new Gson();
        Game config = gson.fromJson(json, Game.class);
        // Window - Frame
        frame = new JFrame();
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLayout(new GridBagLayout());
        // Board & Scenario
        initBoard(config.getBoard(), config.getScenario());
        // Input box
        initInputBox();
        // Log box
        initLogBox();

        frame.setVisible(true);
    }

    private static void initBoard(Board board, Scenario scenario) {
        final CellType defaultCellType = CellType.fromString(board.getDefaultCellType());

        // View
        BoardView.Builder builder = new BoardView.Builder()
                .setSize(board.getSize())
                .setDefaultCellType(defaultCellType);
        for (CellGroup cellGroup : scenario.getCellGroups()) {
            CellType cellType = CellType.fromString(cellGroup.getType());
            java.util.List<Pair<Coordinate, String>> cellData = new ArrayList<>();

            for (Cell cell : cellGroup.getCells()) {
                Coordinate coordinate = new Coordinate(cell.x(), cell.y());
                String value = cell.getValue();
                cellData.add(new Pair<>(coordinate, value));
            }

            builder.setCellType(cellType, cellData);
        }
        boardView = builder.build();
        // Constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1;
        constraints.weightx = 0.7;
        constraints.gridheight = 2;
        constraints.gridy = 0;
        constraints.gridx = 0;

        frame.add(boardView.getContent(), constraints);
    }

    private static void initInputBox() {
        // Constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        // TODO - Implement
        JPanel inputBox = new JPanel();
        inputBox.setBorder(BorderFactory.createDashedBorder(Color.BLUE));
        constraints.weighty = 0.3;
        constraints.weightx = 0.7;
        constraints.gridheight = 1;
        constraints.gridy = 0;
        constraints.gridx = 1;

        frame.add(inputBox, constraints);
    }

    private static void initLogBox() {
        // Constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        // TODO - Implement
        JPanel logBox = new JPanel();
        logBox.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        constraints.weighty = 0.7;
        constraints.weightx = 0.7;
        constraints.gridheight = 1;
        constraints.gridy = 1;
        constraints.gridx = 1;

        frame.add(logBox, constraints);
    }

    // FIXME - Show be private and reimplement
    public static void onInput(String input) {
        boardView.setCellValue(new Coordinate(1, 1), String.valueOf(input));
        boardView.draw();
    }

}
