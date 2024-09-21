package ru.stiffbeards.chess.figures;

public abstract class Figure {
    protected boolean isBlack;

    protected Figure(boolean isBlack) {
        this.isBlack = isBlack;
    }

    public boolean isBlack() {
        return isBlack;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
