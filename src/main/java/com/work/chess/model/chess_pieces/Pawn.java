package main.java.com.work.chess.model.chess_pieces;

import java.util.ArrayList;

import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.enums.PieceType;
import main.java.com.work.chess.factories.SymbolFactory;
import main.java.com.work.chess.model.Board;

public class Pawn extends Piece {

    public Pawn (PieceColor color, Position position) {
        super(SymbolFactory.getSymbol(PieceType.PAWN, color), color, position);
    }

    @Override
    public ArrayList <Position> getValidMoves (Board board) {
        ArrayList<Position> validMoves = new ArrayList<>();

        final int direction = (this.color == PieceColor.WHITE) ? 1 : -1;
        
        Position positionFront1 = new Position(position.getRow() + direction, position.getCol());
        Position positionFront2 = new Position(position.getRow() + (direction * 2), position.getCol());
        Position positionDiagonalLeft = new Position(position.getRow() + direction, position.getCol() - 1);
        Position positionDiagonalRight = new Position(position.getRow() + direction, position.getCol() + 1);

        if (board.isOnLimits(positionFront1) && board.getPieceAt(positionFront1) == null) {
            validMoves.add(positionFront1);

            if (isFirstMove()) {
                if (board.isOnLimits(positionFront2) && board.getPieceAt(positionFront2) == null) {
                    validMoves.add(positionFront2);
                }
            }
        }

        checkCaptureMove(validMoves, board, positionDiagonalLeft);
        checkCaptureMove(validMoves, board, positionDiagonalRight);

        return validMoves;
    }

    private void checkCaptureMove(ArrayList<Position> moves, Board board, Position targetPosition) {
        if (board.isOnLimits(targetPosition)) {
            Piece pieceAtTarget = board.getPieceAt(targetPosition);

            if (pieceAtTarget != null && pieceAtTarget.getColor() != this.color) {
                moves.add(targetPosition);
            }
        }
    }
}