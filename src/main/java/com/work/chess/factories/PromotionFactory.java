package main.java.com.work.chess.factories;

import main.java.com.work.chess.model.chess_pieces.*;
import main.java.com.work.chess.enums.PieceType;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.enums.PieceColor;

public class PromotionFactory {
    private PromotionFactory () {}

    public static Piece create (PieceType type, Piece original) {
        Position pos = original.getPosition();
        PieceColor color = original.getColor();

        return switch (type) {
            case QUEEN  -> new Queen(color, pos);
            case KNIGHT -> new Knight(color, pos);
            case ROOK   -> new Rook(color, pos);
            case BISHOP -> new Bishop(color, pos);
            default -> throw new IllegalArgumentException(
                "Tipo de promoção inválido: " + type
            );
        };
    }
}