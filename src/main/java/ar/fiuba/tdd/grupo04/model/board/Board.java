package ar.fiuba.tdd.grupo04.model.board;

import ar.fiuba.tdd.grupo04.model.inputs.IInput;
import ar.fiuba.tdd.grupo04.model.inputs.factories.IInputFactory;

import java.util.ArrayList;
import java.util.List;

public class Board implements IBoard {
    private List<List<IInput>> cells = new ArrayList();
    private IInputFactory<IInput> inputFactory;

    public Board(Integer rows, Integer columns, IInputFactory<IInput> inputFactory) {
        this.inputFactory = inputFactory;
        this.initCells(rows, columns);
    }

    private void initCells(Integer rows, Integer columns) {
        for (Integer row = 0; row < rows; row++) {
            List<IInput> rowList = new ArrayList<>();
            this.cells.add(rowList);
            for (Integer column = 0; column < columns; column++) {
                rowList.add(inputFactory.createInput(new Coordinate(row, column)));
            }
        }
    }

    @Override
    public IInput get(Coordinate coordinate) {
        return cells.get(coordinate.row()).get(coordinate.column());
    }

    @Override
    public Integer rowsLength() {
        return this.cells.size();
    }

    @Override
    public Integer columnsLength() {
        return this.cells.get(0).size();
    }
}
