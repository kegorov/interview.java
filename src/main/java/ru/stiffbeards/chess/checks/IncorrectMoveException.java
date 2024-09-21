package ru.stiffbeards.chess.checks;

public class IncorrectMoveException extends Exception {
    public IncorrectMoveException(String message) {
        super(message);
    }
}
