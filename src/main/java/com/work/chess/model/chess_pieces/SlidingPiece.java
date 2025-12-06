package main.java.com.work.chess.model.chess_pieces;

import java.util.ArrayList;

import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.util.PieceColor;

public abstract class SlidingPiece extends Piece {
    
    public SlidingPiece (String symbol, PieceColor color, Position position) {
        super(symbol, color, position);
    }

    protected void checkMoveTrajectory (ArrayList <Position> moves, Board board, int deltaRow, int deltaCol) {
        int currentRow = this.position.getRow() + deltaRow;
        int currentCol = this.position.getCol() + deltaCol;

        while (true) {
            Position targetPosition = new Position(currentRow, currentCol);

            if (!board.isOnLimits(targetPosition)) {
                break;
            }

            Piece pieceAtTarget = board.getPieceAt(targetPosition);

            if (pieceAtTarget == null) {
                moves.add(targetPosition);
            } else {
                if (pieceAtTarget.getColor() != this.color) {
                    moves.add(targetPosition);
                }
                break;
            }

            currentRow += deltaRow;
            currentCol += deltaCol;
        }
    }
}