package main.java.com.work.chess.controller;

import main.java.com.work.chess.model.Piece;
import java.security.InvalidParameterException;

import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Position;

public class PieceMover {
    private PieceMover () {}

    public static void move (Board board, Piece piece, Position newPosition) {
        PieceMover.validateMove(piece, board, newPosition);

        try {
            board.setPieceAt(piece.getPosition(), null);
            piece.setPosition(newPosition);
            board.setPieceAt(newPosition, piece);
        } catch (Exception e) {
            throw new InvalidParameterException("Posição inválida.");
        }
    }

    private static void validateMove (Piece piece, Board board, Position newPosition) {
        if (!piece.getValidMoves(board).contains(newPosition)) {
            throw new IllegalArgumentException("[WARNING]: Movimento Inválido.");
        }
    }
}