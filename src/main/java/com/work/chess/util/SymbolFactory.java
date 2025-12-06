package main.java.com.work.chess.util;

import main.java.com.work.chess.enums.PieceType;
import main.java.com.work.chess.enums.PieceColor;

import java.util.Map;

public class SymbolFactory {

    private static final Map<String, String> SYMBOLS = Map.ofEntries(
        Map.entry("QUEEN_WHITE", "♕"),
        Map.entry("QUEEN_BLACK", "♛"),
        Map.entry("KING_WHITE", "♔"),
        Map.entry("KING_BLACK", "♚"),
        Map.entry("ROOK_WHITE", "♖"),
        Map.entry("ROOK_BLACK", "♜"),
        Map.entry("BISHOP_WHITE", "♗"),
        Map.entry("BISHOP_BLACK", "♝"),
        Map.entry("KNIGHT_WHITE", "♘"),
        Map.entry("KNIGHT_BLACK", "♞"),
        Map.entry("PAWN_WHITE", "♙"),
        Map.entry("PAWN_BLACK", "♟")
    );

    private SymbolFactory() {}

    public static String getSymbol(PieceType type, PieceColor color) {
        return SYMBOLS.get(type.name() + "_" + color.name());
    }
}