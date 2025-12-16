package main.java.com.work.chess.model;

import main.java.com.work.chess.interfaces.ISpecialMove;
import main.java.com.work.chess.model.chess_pieces.King;
import main.java.com.work.chess.model.chess_pieces.Piece;
import main.java.com.work.chess.model.chess_pieces.Rook;
import main.java.com.work.chess.controller.ChessRules;

public class Castling implements ISpecialMove {

    @Override
    public boolean canExecute (Board board, Move move) {
        if (!(move.getPiece() instanceof King)) {
            return false;
        }

        if (ChessRules.isKingInCheck(board, move.getPiece().getColor())) {
            return false;
        }

        int deltaCol = Math.abs(move.getOrigin().getCol () - move.getDestiny().getCol ());
        if (deltaCol != 2) return false;

        if (!move.getPiece().isFirstMove ()) return false;

        int row = move.getOrigin().getRow ();
        boolean isKingside = move.getDestiny().getCol () > move.getOrigin().getCol ();
        int rookCol = isKingside ? 8 : 1;

        int middleCol = isKingside ? 6 : 4;
        Position middlePos = new Position(row, middleCol);
        
        if (ChessRules.isSquareAttacked(board, middlePos, move.getPiece().getColor())) {
            return false;
        }
        
        Piece rook = board.getPieceAt (new Position (row, rookCol));
        
        if (rook == null || !(rook instanceof Rook) || !rook.isFirstMove ()) {
            return false;
        }

        int startCol = Math.min (move.getOrigin().getCol (), rookCol) + 1;
        int endCol = Math.max (move.getOrigin().getCol (), rookCol) - 1;

        for (int col = startCol; col <= endCol; col++) {
            if (board.getPieceAt (new Position (row, col)) != null) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void execute (Board board, Move move) {
        int row = move.getDestiny().getRow ();
        boolean isKingside = move.getDestiny().getCol () > move.getOrigin().getCol ();

        Position rookOriginPos;
        Position rookTargetPos;

        if (isKingside) {
            rookOriginPos = new Position (row, 8);
            rookTargetPos = new Position (row, 6);
        } else {
            rookOriginPos = new Position (row, 1);
            rookTargetPos = new Position (row, 4);
        }

        Piece rook = board.getPieceAt (rookOriginPos);
        
        if (rook != null) {
            try {
                board.setPieceAt (rookOriginPos, null);
                rook.setPosition (rookTargetPos);
                board.setPieceAt (rookTargetPos, rook);
            } catch (Exception e) {
                System.out.println (e.getMessage ());
            }
        }
    }
}