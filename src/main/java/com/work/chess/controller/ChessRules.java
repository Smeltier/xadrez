package main.java.com.work.chess.controller;

import java.util.List;
import java.util.ArrayList;

import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.model.chess_pieces.King;
import main.java.com.work.chess.model.chess_pieces.Piece;

public class ChessRules {

    private ChessRules () {}

    public static boolean isMoveLegal (Board board, Piece piece, Position from, Position to) {
        List <Position> validMoves = piece.getValidMoves (board);
        
        boolean isGeometricValid = validMoves.stream ()
            .anyMatch (p -> p.getRow () == to.getRow () && p.getCol () == to.getCol ());

        if (!isGeometricValid) {
            return false;
        }

        Piece capturedPiece = board.getPieceAt (to);
        
        try {
            board.setPieceAt (to, piece);
            board.setPieceAt (from, null);
            piece.setPosition (to); 

            if (isKingInCheck (board, piece.getColor ())) {
                undoMove(board, piece, from, to, capturedPiece);
                return false;
            }

            undoMove(board, piece, from, to, capturedPiece);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private static void undoMove(Board board, Piece piece, Position from, Position to, Piece capturedPiece) {
        try {
            board.setPieceAt (from, piece);
            board.setPieceAt (to, capturedPiece);
            piece.setPosition (from);
        } catch (Exception e) {}
    }

    public static boolean isKingInCheck (Board board, PieceColor kingColor) {
        Position kingPosition = findKingPosition (board, kingColor);
        
        if (kingPosition == null) return false;

        PieceColor enemyColor = (kingColor == PieceColor.WHITE) ? PieceColor.BLACK : PieceColor.WHITE;
        List <Piece> enemyPieces = getPiecesByColor (board, enemyColor);

        for (Piece enemy : enemyPieces) {
            List <Position> threats = enemy.getValidMoves (board);
            for (Position threat : threats) {
                if (threat.equals (kingPosition)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCheckMate (Board board, PieceColor kingColor) {
        if (!isKingInCheck (board, kingColor)) {
            return false;
        }

        List <Piece> myPieces = getPiecesByColor (board, kingColor);

        for (Piece piece : myPieces) {
            List <Position> potentialMoves = piece.getValidMoves (board);
            
            for (Position dest : potentialMoves) {
                if (isMoveLegal (board, piece, piece.getPosition (), dest)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static Position findKingPosition (Board board, PieceColor color) {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                Piece p = board.getPieceAt (new Position (i, j));
                if (p instanceof King && p.getColor () == color) {
                    return p.getPosition ();
                }
            }
        }
        return null;
    }

    private static List <Piece> getPiecesByColor (Board board, PieceColor color) {
        List <Piece> pieces = new ArrayList <> ();
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                Piece p = board.getPieceAt (new Position (i, j));
                if (p != null && p.getColor () == color) {
                    pieces.add (p);
                }
            }
        }
        return pieces;
    }
}