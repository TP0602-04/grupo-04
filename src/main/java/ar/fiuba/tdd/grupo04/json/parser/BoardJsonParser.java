package ar.fiuba.tdd.grupo04.json.parser;

import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.inputs.factories.NumericInputFactory;
import ar.fiuba.tdd.grupo04.json.model.JsonBoard;

public class BoardJsonParser {
    public static Board parse(JsonBoard jsonBoard) {
        Integer rows = jsonBoard.getRows();
        Integer columns = jsonBoard.getColumns();
//        String cellType = jsonBoard.getCellType();
        //TODO
        Board board = new Board<>(rows, columns, new NumericInputFactory());
        //if(cellType.equals("Integer")) {
        return board;
    }
}
