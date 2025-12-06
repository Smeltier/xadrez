package main.java.com.work.chess.controller;

import main.java.com.work.chess.model.chess_pieces.*;
import main.java.com.work.chess.enums.PieceType;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.util.SymbolFactory;

public class PromotionFactory {
    private PromotionFactory () {}

    public static Piece create(PieceType type, Piece original) {
        Position pos = original.getPosition();
        PieceColor color = original.getColor();
        String symbol = SymbolFactory.getSymbol(type, color);

        return switch (type) {
            case QUEEN  -> new Queen(symbol, color, pos);
            case KNIGHT -> new Knight(symbol, color, pos);
            case ROOK   -> new Rook(symbol, color, pos);
            case BISHOP -> new Bishop(symbol, color, pos);
            default -> throw new IllegalArgumentException(
                "[WARNING]: Tipo de promoção inválido: " + type
            );
        };
    }
}