package ru.stiffbeards.chess.figures;

public class Queen extends Figure {
    public Queen(boolean isBlack) {
        super(isBlack);
    }

    @Override
    public String toString() {
        return isBlack ? "♛" : "♕";
    }
}
