package ru.stiffbeards.chess;

import java.util.regex.Pattern;

public final class Moves {

    private static final String NOTATION_PATTERN = "^([a-h])([1-8])-([a-h])([1-8])$";
    private static final Pattern REGEX_PATTERN = Pattern.compile(NOTATION_PATTERN);
    private static final String ERROR_MESSAGE = "Move notation is incorrect: ";

    public static Move fromString(String move) throws IllegalArgumentException {
        if (!isNotationValid(move)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + move);
        }
        return parseNotation(move);
    }

    public static boolean isNotationValid(String move) {
        return move != null && REGEX_PATTERN.matcher(move).matches();
    }

    private static Move parseNotation(String move) {
        return new Move(
                move.charAt(0),
                Character.getNumericValue(move.charAt(1)),
                move.charAt(3),
                Character.getNumericValue(move.charAt(4))
        );
    }
}
