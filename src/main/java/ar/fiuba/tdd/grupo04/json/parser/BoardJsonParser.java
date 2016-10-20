package ar.fiuba.tdd.grupo04.json.parser;

import ar.fiuba.tdd.grupo04.board.Board;
import ar.fiuba.tdd.grupo04.json.model.JsonBoard;

public class BoardJsonParser {
    public static Board parse(JsonBoard jsonBoard) {
        Integer rows = jsonBoard.getRows();
        Integer columns = jsonBoard.getColumns();
        String cellType = jsonBoard.getCellType();
        Board<?> board;
        if(cellType.equals("Integer")) {
            board = new Board<Integer>(rows, columns);
        } else {
            board = new Board<String>(rows, columns);
        }
        return board;
    }
}
