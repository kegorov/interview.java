package ru.stiffbeards.chess.figures;

public class Bishop extends Figure {
    public Bishop(boolean isBlack) {
        super(isBlack);
    }

    @Override
    public String toString() {
        return isBlack ? "♝" : "♗";
    }
}
