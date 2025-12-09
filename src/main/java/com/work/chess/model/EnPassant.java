package main.java.com.work.chess.model;

import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.interfaces.ISpecialMoves;
import main.java.com.work.chess.model.chess_pieces.Pawn;
import main.java.com.work.chess.model.chess_pieces.Piece;

public class EnPassant implements ISpecialMoves {

    @Override
    public boolean canExecute (Board board, Move move) {
        if (!(move.piece instanceof Pawn)) {
            return false;
        }
        
        if (move.from.getCol () == move.to.getCol ()) {
            return false;
        }

        if (move.capturedPiece != null) {
            return false;
        }

        int enemyPawnRow = move.from.getRow ();
        int enemyPawnCol = move.to.getCol ();
        Position enemyPosition = new Position (enemyPawnRow, enemyPawnCol);
        
        Piece enemyPiece = board.getPieceAt (enemyPosition);

        return enemyPiece instanceof Pawn && enemyPiece.getColor () != move.piece.getColor ();
    }

    @Override
    public void execute (Board board, Move move) {
        int directionBack = (move.piece.getColor () == PieceColor.WHITE) ? -1 : 1;
        
        Position enemyPawnPos = new Position (move.to.getRow () + directionBack, move.to.getCol ());
        
        try {
            board.setPieceAt (enemyPawnPos, null);
        } catch (Exception e) {
            System.out.println (e.getMessage ());
        }
    }
}