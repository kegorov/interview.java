package ru.stiffbeards.chess.figures;

public class Pawn extends Figure {
    public Pawn(boolean isBlack) {
        super(isBlack);
    }

    @Override
    public String toString() {
        return isBlack ? "♟" : "♙";
    }
}
