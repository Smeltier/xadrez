package main.java.com.work.chess.controller;

import java.util.List;
import java.util.ArrayList;

import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Move;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.model.chess_pieces.King;
import main.java.com.work.chess.model.chess_pieces.Piece;

public class ChessRules {

    private ChessRules () {}

    public static boolean isMoveLegal (Board board, Move move) {
        Piece piece = move.getPiece();
        Position to = move.getDestiny();

        boolean isGeometricValid = piece.getValidMoves(board).stream()
            .anyMatch(p -> p.equals(to));

        if (!isGeometricValid) {
            return false;
        }

        // Piece capturedPiece = move.getCapturedPiece();
        Position from = move.getOrigin();
        
        board.setPieceAt(to, piece);
        board.setPieceAt(from, null);
        piece.setPosition(to);

        boolean kingInCheck = isKingInCheck(board, piece.getColor());

        undoMove(board, move);

        return !kingInCheck;
    }

    public static boolean isKingInCheck (Board board, PieceColor kingColor) {
        Position kingPosition = findKingPosition(board, kingColor);

        if (kingPosition == null) return false;

        PieceColor enemyColor = (kingColor == PieceColor.WHITE) ? PieceColor.BLACK : PieceColor.WHITE;
        List<Piece> enemyPieces = getPiecesByColor(board, enemyColor);

        for (Piece enemy : enemyPieces) {
            List<Position> threats = enemy.getValidMoves(board);
            for (Position threat : threats) {
                if (threat.equals(kingPosition)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCheckMate (Board board, PieceColor kingColor) {
        if (!isKingInCheck(board, kingColor)) {
            return false;
        }

        List<Piece> myPieces = getPiecesByColor(board, kingColor);

        for (Piece piece : myPieces) {
            List<Position> potentialMoves = piece.getValidMoves(board);

            for (Position dest : potentialMoves) {
                Piece capturedContent = board.getPieceAt(dest);
                Move emulationMove = new Move(piece, piece.getPosition(), dest, capturedContent);

                if (isMoveLegal(board, emulationMove)) {
                    return false;
                }
            }
        }
        
        return true;
    }

    private static void undoMove (Board board, Move move) {
        Position origin = move.getOrigin();
        Position destiny = move.getDestiny();
        Piece piece = move.getPiece();
        Piece captured = move.getCapturedPiece();

        board.setPieceAt(origin, piece);
        board.setPieceAt(destiny, captured);
        piece.setPosition(origin);
    }

    private static Position findKingPosition (Board board, PieceColor color) {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                Position pos = new Position(i, j);
                Piece p = board.getPieceAt(pos);

                if (p instanceof King && p.getColor() == color) {
                    return pos;
                }
            }
        }

        return null;
    }

    private static List<Piece> getPiecesByColor (Board board, PieceColor color) {
        List<Piece> pieces = new ArrayList<>();

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                Piece p = board.getPieceAt(new Position(i, j));

                if (p != null && p.getColor() == color) {
                    pieces.add(p);
                }
            }
        }
        
        return pieces;
    }
}