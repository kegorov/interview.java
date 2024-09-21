package ru.stiffbeards.chess;

import java.util.Objects;

public final class Move {
    private final char xFrom;
    private final int yFrom;
    private final char xTo;
    private final int yTo;

    public Move(char xFrom, int yFrom, char xTo, int yTo) {
        this.xFrom = xFrom;
        this.yFrom = yFrom;
        this.xTo = xTo;
        this.yTo = yTo;
    }

    public char getxFrom() {
        return xFrom;
    }

    public int getyFrom() {
        return yFrom;
    }

    public char getxTo() {
        return xTo;
    }

    public int getyTo() {
        return yTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return xFrom == move.xFrom && yFrom == move.yFrom && xTo == move.xTo && yTo == move.yTo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xFrom, yFrom, xTo, yTo);
    }

    @Override
    public String toString() {
        return "Move{" +
                "xFrom=" + xFrom +
                ", yFrom=" + yFrom +
                ", xTo=" + xTo +
                ", yTo=" + yTo +
                '}';
    }
}
