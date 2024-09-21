package ru.stiffbeards.chess.checks;

import ru.stiffbeards.chess.Move;
import ru.stiffbeards.chess.figures.Figure;

import java.util.List;

public class MoveOrderChecker implements MoveChecker {

    private static final String ERROR_MESSAGE = "Incorrect move order: ";
    private final List<Move> records;


    public MoveOrderChecker(List<Move> records) {
        this.records = records;
    }

    @Override
    public void check(Figure figure, Move move) throws IncorrectMoveException {
        if (figure.isBlack() != isBlackOrder()) {
            throw new IncorrectMoveException(ERROR_MESSAGE + move);
        }
    }

    private boolean isBlackOrder() {
        return !(records.size() % 2 == 0);
    }
}
