package main.java.com.work.chess.model.chess_pieces;

import java.util.ArrayList;

import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.util.PieceColor;

public class Knight extends Piece {   
    public Knight (String symbol, PieceColor color, Position position) {
        super(symbol, color, position);
    }

    @Override
    public ArrayList <Position> getValidMoves (Board board) {
        ArrayList <Position> validMoves = new ArrayList<>();

        int[] dx = {-2, -2, -1, -1,  1, 1,  2, 2};
        int[] dy = {-1,  1, -2,  2, -2, 2, -1, 1};

        for (int direction = 0; direction < 8; direction++) {
            int targetRow = this.position.getRow() + dx[direction];
            int targetCol = this.position.getCol() + dy[direction];

            Position targetPosition = new Position(targetRow, targetCol);

            if (!board.isOnLimits(targetPosition)) {
                continue;
            }

            Piece pieceAtTarget = board.getPieceAt(targetPosition);

            if (pieceAtTarget == null || pieceAtTarget.getColor() != this.color) {
                validMoves.add(targetPosition);
            }
        }

        return validMoves;
    }
}