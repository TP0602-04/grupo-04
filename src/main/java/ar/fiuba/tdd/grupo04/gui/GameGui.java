package ar.fiuba.tdd.grupo04.gui;

import com.google.gson.Gson;

import ar.fiuba.tdd.grupo04.IGame;
import ar.fiuba.tdd.grupo04.board.Coordinate;
import ar.fiuba.tdd.grupo04.gui.cell.CellType;
import ar.fiuba.tdd.grupo04.gui.model.*;
import javafx.util.Pair;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GameGui implements BoardView.Observer, InputBoxView.SubmitListener {
    private static final int WINDOW_WIDTH = 900;
    private static final int WINDOW_HEIGHT = 600;

    private IGame game;
    private JFrame frame;
    private BoardView boardView;
    private InputBoxView inputBoxView;

    public GameGui(String json, IGame game) {
        this.game = game;
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

    /*
     * {@link BoardView.Observer} implementation
     */
    @Override
    public void onCellSelected(Coordinate coordinate) {
        inputBoxView.select(coordinate);
    }

    /*
     * {@link InputBoxView.SubmitListener} implementation
     */
    @Override
    public void onSubmit(Coordinate coordinate, String input) {
        // FIXME - THE CAST SHOULD BE HANDLED BY ANOTHER COMPONENT - NOT DECIDED YET!!!
//        game.fillCell(coordinate, Integer.valueOf(input));
        boardView.setCellValue(coordinate, input);
        if (game.checkWinRules()) {
            System.out.println("GANASTE");
        } else {
            System.out.println("PERDISTE");
        }
    }

    /*
     * Private methods
     */
    private void initBoard(Board board, Scenario scenario) {
        final CellType defaultCellType = CellType.fromString(board.getDefaultCellType());

        // BoardView creation
        BoardView.Builder builder = new BoardView.Builder(board.getSize(), defaultCellType);
        for (UiCellGroup cellGroup : scenario.getUtilCells()) {
            CellType cellType = CellType.fromString(cellGroup.getCellType());
            java.util.List<Pair<Coordinate, String>> cellData = new ArrayList<>();

            for (Cell cell : cellGroup.getCells()) {
                Coordinate coordinate = new Coordinate(cell.row(), cell.column());
                String value = cell.getValue();
                cellData.add(new Pair<>(coordinate, value));
            }

            builder.setCellType(cellType, cellData);
        }
        for (Reference reference : scenario.getReferences()) {
            java.util.List<Coordinate> coordinateList = new ArrayList<>();
            java.util.List<Cell> cells = reference.getCells();

            for (Cell cell : cells) {
                Coordinate coordinate = new Coordinate(cell.row(), cell.column());
                coordinateList.add(coordinate);
            }

            builder.addPerimeter(coordinateList);
        }
        boardView = builder.build();

        // Add Observer to BoardView in order receive callback from it
        boardView.addObserver(this);

        // Sizing / Locating BoardView within frame
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1;
        constraints.weightx = 0.7;
        constraints.gridheight = 2;
        constraints.gridy = 0;
        constraints.gridx = 0;

        frame.add(boardView.getContent(), constraints);
    }

    private void initInputBox() {
        inputBoxView = new InputBoxView();
        JPanel inputBox = inputBoxView.getContent();
        inputBox.setBorder(BorderFactory.createDashedBorder(Color.BLUE));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 0.3;
        constraints.weightx = 0.7;
        constraints.gridheight = 1;
        constraints.gridy = 0;
        constraints.gridx = 1;

        frame.add(inputBox, constraints);

        inputBoxView.addListener(this);
    }

    private void initLogBox() {
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

}
