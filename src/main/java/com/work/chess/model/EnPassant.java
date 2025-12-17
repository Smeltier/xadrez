package main.java.com.work.chess.model;

import main.java.com.work.chess.interfaces.ISpecialMove;
import main.java.com.work.chess.model.chess_pieces.Pawn;

public class EnPassant implements ISpecialMove {

    @Override
    public boolean canExecute (Board board, Move move) {
        if (!(move.getPiece() instanceof Pawn)) {
            return false;
        }

        if (board.getEnPassantVulnerable() == null) {
            return false;
        }

        Position target = board.getEnPassantVulnerable();
        
        boolean isGoingToTarget = move.getDestiny().getRow() == target.getRow() && 
                                  move.getDestiny().getCol() == target.getCol();

        if (!isGoingToTarget) {
            return false;
        }

        if (move.getOrigin().getCol() == move.getDestiny().getCol()) {
            return false;
        }

        return true;
    }

    @Override
    public void execute (Board board, Move move) {
        int enemyRow = move.getOrigin().getRow();
        int enemyCol = move.getDestiny().getCol();
        
        Position enemyPawnPos = new Position(enemyRow, enemyCol);
        
        try {
            board.setPieceAt(enemyPawnPos, null);
        } catch (Exception e) {
            System.out.println("Erro ao executar En Passant: " + e.getMessage());
        }
    }
}