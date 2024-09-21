package ru.stiffbeards.chess.checks;

import com.google.common.collect.Table;
import ru.stiffbeards.chess.Move;
import ru.stiffbeards.chess.figures.Figure;
import ru.stiffbeards.chess.figures.Pawn;

import java.util.HashMap;
import java.util.Map;

public class DelegatingFigureMoveChecker implements MoveChecker {
    private final Map<Class<? extends Figure>, MoveChecker> delegates = new HashMap<>();

    public DelegatingFigureMoveChecker(Table<Integer, Character, Figure> figures) {
        this.delegates.put(Pawn.class, new PawnMoveChecker(figures));
    }

    @Override
    public void check(Figure figure, Move move) throws IncorrectMoveException {
        Class<? extends Figure> clazz = figure.getClass();
        if (delegates.containsKey(clazz)) {
            delegates.get(clazz).check(figure, move);
        }
    }
}
