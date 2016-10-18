package ar.fiuba.tdd.grupo04.gui.exception;

public class IllegalInputException extends RuntimeException {
    private String message;

    public IllegalInputException(String msg) {
        message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
