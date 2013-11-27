package ru.stiffbeards.chess.figures;

public class King extends Figure {
    public King(boolean isBlack) {
        super(isBlack);
    }

    @Override
    public String toString() {
        return isBlack ? "♚" : "♔";
    }
}
