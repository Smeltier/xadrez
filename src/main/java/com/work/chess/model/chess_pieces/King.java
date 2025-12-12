package main.java.com.work.chess.model.chess_pieces;

import java.util.ArrayList;

import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.enums.PieceType;
import main.java.com.work.chess.factories.SymbolFactory;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Position;

public class King extends Piece {

    public King(PieceColor color, Position position) {
        super(SymbolFactory.getSymbol(PieceType.KING, color), color, position);
    }

    @Override
    public ArrayList<Position> getValidMoves(Board board) {
        ArrayList<Position> validMoves = new ArrayList<>();
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1}, 
            {1, -1},  {1, 0},  {1, 1}  
        };

        for (int[] dir : directions) {
            Position p = new Position(position.getRow() + dir[0], position.getCol() + dir[1]);
            if (board.isOnLimits(p)) {
                Piece piece = board.getPieceAt(p);

                if (piece == null || piece.getColor() != this.color) {
                    validMoves.add(p);
                }
            }
        }

        if (isFirstMove()) {
            Piece rookRight = board.getPieceAt(new Position(position.getRow(), 8));

            if (rookRight != null && rookRight instanceof Rook && rookRight.isFirstMove()) {
                Position p1 = new Position(position.getRow(), 6);
                Position p2 = new Position(position.getRow(), 7);

                if (board.getPieceAt(p1) == null && board.getPieceAt(p2) == null) {
                    validMoves.add(new Position(position.getRow(), 7));
                }
            }

            Piece rookLeft = board.getPieceAt(new Position(position.getRow(), 1));

            if (rookLeft != null && rookLeft instanceof Rook && rookLeft.isFirstMove()) {
                Position p1 = new Position(position.getRow(), 2);
                Position p2 = new Position(position.getRow(), 3);
                Position p3 = new Position(position.getRow(), 4);

                if (board.getPieceAt(p1) == null && board.getPieceAt(p2) == null && board.getPieceAt(p3) == null) {
                    validMoves.add(new Position(position.getRow(), 3));
                }
            }
        }

        return validMoves;
    }
}