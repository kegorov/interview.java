package ru.stiffbeards.chess.checks;

import com.google.common.collect.Table;
import ru.stiffbeards.chess.Move;
import ru.stiffbeards.chess.figures.Figure;

public class PawnMoveChecker implements MoveChecker {

    private static final String ERROR_MESSAGE = "Incorrect Pawn move: ";

    private final Table<Integer, Character, Figure> figures;

    public PawnMoveChecker(Table<Integer, Character, Figure> figures) {
        this.figures = figures;
    }

    @Override
    public void check(Figure figure, Move move) throws IncorrectMoveException {
        boolean isBlack = figure.isBlack();
        if (isStraightMove(move, isBlack) && isMoveForward(move, isBlack) && isPathClear(move, isBlack)) {
            return;
        }
        if (isDiagonalMove(move) && isMoveForward(move, isBlack) && isAttack(move)) {
            return;
        }
        throw new IncorrectMoveException(ERROR_MESSAGE + move);
    }

    private boolean isMoveForward(Move move, boolean isBlack) {
        return isBlack ? move.getyFrom() > move.getyTo() : move.getyFrom() < move.getyTo();
    }

    private boolean isStraightMove(Move move, boolean isBlack) {
        boolean isStrait = move.getxFrom() == move.getxTo();
        boolean isFirstMove = isBlack ? move.getyFrom() == 7 : move.getyFrom() == 2;
        int length = Math.abs(move.getyFrom() - move.getyTo());
        return isStrait && (isFirstMove ? length <= 2 : length <= 1);
    }

    private boolean isPathClear(Move move, boolean isBlack) {
        boolean innerSquare = false;
        boolean lastSquare = figures.contains(move.getyTo(), move.getxTo());
        boolean isFirstMove = isBlack ? move.getyFrom() == 7 : move.getyFrom() == 2;
        if (isFirstMove) {
            int y = isBlack ? 6 : 3;
            innerSquare = figures.contains(y, move.getxTo());
        }
        return !(innerSquare || lastSquare);
    }

    private boolean isDiagonalMove(Move move) {
        int x = Math.abs(move.getxFrom() - move.getxTo());
        int y = Math.abs(move.getyFrom() - move.getyTo());
        return x == 1 && y == 1;
    }

    private boolean isAttack(Move move) throws IncorrectMoveException {
        if (!figures.contains(move.getyTo(), move.getxTo())) {
            return false;
        }
        Figure from = figures.get(move.getyFrom(), move.getxFrom());
        Figure to = figures.get(move.getyTo(), move.getxTo());
        if (from.isBlack() == to.isBlack()) {
            throw new IncorrectMoveException(ERROR_MESSAGE + move);
        }
        return true;
    }
}
