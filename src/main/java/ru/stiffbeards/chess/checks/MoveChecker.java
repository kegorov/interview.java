package ru.stiffbeards.chess.checks;

import ru.stiffbeards.chess.Move;
import ru.stiffbeards.chess.figures.Figure;

public interface MoveChecker {
    void check(Figure figure, Move move) throws IncorrectMoveException;
}
