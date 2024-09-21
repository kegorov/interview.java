package ru.stiffbeards.chess.checks;

import com.google.common.collect.Table;
import ru.stiffbeards.chess.Move;
import ru.stiffbeards.chess.figures.Figure;

import java.util.ArrayList;
import java.util.List;

public class DelegatingMoveChecker implements MoveChecker {

    private final List<MoveChecker> delegates = new ArrayList<>();

    public DelegatingMoveChecker(Table<Integer, Character, Figure> figures, List<Move> records) {
        delegates.add(new MoveOrderChecker(records));
        delegates.add(new DelegatingFigureMoveChecker(figures));
    }

    @Override
    public void check(Figure figure, Move move) throws IncorrectMoveException {
        for (MoveChecker delegate : delegates) {
            delegate.check(figure, move);
        }
    }
}
