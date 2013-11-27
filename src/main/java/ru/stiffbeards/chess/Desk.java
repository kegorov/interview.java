package ru.stiffbeards.chess;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import ru.stiffbeards.chess.figures.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Desk {
    private Table<Integer, Character, Figure> figures = HashBasedTable.create();

    public Desk() {
        figures.put(1, 'a', new Rook(false));
        figures.put(1, 'b', new Knight(false));
        figures.put(1, 'c', new Bishop(false));
        figures.put(1, 'd', new Queen(false));
        figures.put(1, 'e', new King(false));
        figures.put(1, 'f', new Bishop(false));
        figures.put(1, 'g', new Knight(false));
        figures.put(1, 'h', new Rook(false));

        figures.put(2, 'a', new Pawn(false));
        figures.put(2, 'b', new Pawn(false));
        figures.put(2, 'c', new Pawn(false));
        figures.put(2, 'd', new Pawn(false));
        figures.put(2, 'e', new Pawn(false));
        figures.put(2, 'f', new Pawn(false));
        figures.put(2, 'g', new Pawn(false));
        figures.put(2, 'h', new Pawn(false));

        figures.put(7, 'a', new Pawn(true));
        figures.put(7, 'b', new Pawn(true));
        figures.put(7, 'c', new Pawn(true));
        figures.put(7, 'd', new Pawn(true));
        figures.put(7, 'e', new Pawn(true));
        figures.put(7, 'f', new Pawn(true));
        figures.put(7, 'g', new Pawn(true));
        figures.put(7, 'h', new Pawn(true));

        figures.put(8, 'a', new Rook(true));
        figures.put(8, 'b', new Knight(true));
        figures.put(8, 'c', new Bishop(true));
        figures.put(8, 'd', new Queen(true));
        figures.put(8, 'e', new King(true));
        figures.put(8, 'f', new Bishop(true));
        figures.put(8, 'g', new Knight(true));
        figures.put(8, 'h', new Rook(true));
    }

    public void move(String move) throws Exception {
        Pattern movePattern = Pattern.compile("^([a-h])(\\d)-([a-h])(\\d)$");
        Matcher moveMatcher = movePattern.matcher(move);
        if (!moveMatcher.matches()) {
            throw new Exception("Incorrect move");
        }

        Character xFrom = moveMatcher.group(1).charAt(0);
        Integer yFrom = Integer.parseInt(moveMatcher.group(2));
        Character xTo = moveMatcher.group(3).charAt(0);
        Integer yTo = Integer.parseInt(moveMatcher.group(4));

        if (figures.contains(yFrom, xFrom)) {
            figures.put(yTo, xTo, figures.get(yFrom, xFrom));
        }
        figures.remove(yFrom, xFrom);
    }

    public String dump() {
        String res = "";
        for (int y = 8; y >= 1; y--) {
            res += String.valueOf(y) + " ";
            for (char x = 'a'; x <= 'h'; x++) {
                if (figures.contains(y, x)) {
                    res += figures.get(y, x);
                } else {
                    res += "-";
                }
            }
            res += "\n";
        }
        res += "  abcdefgh\n";

        return res;
    }
}
