package ar.fiuba.tdd.grupo04.json.parser;

import ar.fiuba.tdd.grupo04.json.model.JsonBoard;
import ar.fiuba.tdd.grupo04.model.board.Board;
import ar.fiuba.tdd.grupo04.model.board.IBoard;
import ar.fiuba.tdd.grupo04.model.inputs.factories.DiagonalInputFactory;
import ar.fiuba.tdd.grupo04.model.inputs.factories.GraphInputFactory;
import ar.fiuba.tdd.grupo04.model.inputs.factories.NumericInputFactory;

public class BoardJsonParser {
    public static IBoard parse(JsonBoard jsonBoard) {
        Integer rows = jsonBoard.getRows();
        Integer columns = jsonBoard.getColumns();
        String inputType = jsonBoard.getInputType();
        switch (inputType) {
            case "NumericInput": return new Board<>(rows, columns, new NumericInputFactory());
            case "GraphInput": return new Board<>(rows, columns, new GraphInputFactory());
            case "DiagonalInput": return new Board<>(rows, columns, new DiagonalInputFactory());
        }
        return null;
    }
}
