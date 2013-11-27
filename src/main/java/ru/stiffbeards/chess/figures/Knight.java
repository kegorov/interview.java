package ru.stiffbeards.chess.figures;

public class Knight extends Figure {
    public Knight(boolean isBlack) {
        super(isBlack);
    }

    @Override
    public String toString() {
        return isBlack ? "♞" : "♘";
    }
}
