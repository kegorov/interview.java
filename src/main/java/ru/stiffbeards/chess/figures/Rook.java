package ru.stiffbeards.chess.figures;

public class Rook extends Figure {
    public Rook(boolean isBlack) {
        super(isBlack);
    }

    @Override
    public String toString() {
        return isBlack ? "♜" : "♖";
    }
}
