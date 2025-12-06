package main.java.com.work.chess.model.chess_pieces;

import java.util.ArrayList;

import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.model.Board;

public class Pawn extends Piece {
    private boolean isFirstMove;

    public Pawn (String symbol, PieceColor color, Position position) {
        super(symbol, color, position);
        this.isFirstMove = true;
    }

    @Override
    public ArrayList <Position> getValidMoves (Board board) {
        ArrayList<Position> validMovies = new ArrayList<>();

        if (this.color == PieceColor.WHITE) {
            Position positionFront1 = new Position(position.getRow() + 1, position.getCol());
            Position positionFront2 = new Position(position.getRow() + 2, position.getCol());
            Position positionDiagonalLeft = new Position(position.getRow() + 1, position.getCol() - 1);
            Position positionDiagonalRight = new Position(position.getRow() + 1, position.getCol() + 1);

            if (isFirstMove) {
                if (board.getPieceAt(positionFront1) == null) {
                    validMovies.add(positionFront1);

                    if (board.getPieceAt(positionFront2) == null) {
                        validMovies.add(positionFront2);
                    }
                }
            }
            else {
                if (board.isOnLimits(positionFront1) && board.getPieceAt(positionFront1) == null) {
                    validMovies.add(positionFront1);
                }
            }

            if (board.isOnLimits(positionDiagonalLeft) && board.getPieceAt(positionDiagonalLeft) != null) {
                Piece pieceDiagonalLeft = board.getPieceAt(positionDiagonalLeft);

                if (this.color != pieceDiagonalLeft.color) {
                    validMovies.add(positionDiagonalLeft);
                }
            }

            if (board.isOnLimits(positionDiagonalRight) && board.getPieceAt(positionDiagonalRight) != null) {
                Piece pieceDiagonalRight = board.getPieceAt(positionDiagonalRight);

                if (this.color != pieceDiagonalRight.color) {
                    validMovies.add(positionDiagonalRight);
                }
            }
        }
        else {
            Position positionFront1 = new Position(position.getRow() - 1, position.getCol());
            Position positionFront2 = new Position(position.getRow() - 2, position.getCol());
            Position positionDiagonalLeft = new Position(position.getRow() - 1, position.getCol() - 1);
            Position positionDiagonalRight = new Position(position.getRow() - 1, position.getCol() + 1);

            if (isFirstMove) {
                if (board.getPieceAt(positionFront1) == null) {
                    validMovies.add(positionFront1);

                    if (board.getPieceAt(positionFront2) == null) {
                        validMovies.add(positionFront2);
                    }
                }
            }
            else {
                if (board.isOnLimits(positionFront1) && board.getPieceAt(positionFront1) == null) {
                    validMovies.add(positionFront1);
                }
            }

            if (board.isOnLimits(positionDiagonalLeft) && board.getPieceAt(positionDiagonalLeft) != null) {
                Piece pieceDiagonalLeft = board.getPieceAt(positionDiagonalLeft);

                if (this.color != pieceDiagonalLeft.color) {
                    validMovies.add(positionDiagonalLeft);
                }
            }

            if (board.isOnLimits(positionDiagonalRight) && board.getPieceAt(positionDiagonalRight) != null) {
                Piece pieceDiagonalRight = board.getPieceAt(positionDiagonalRight);

                if (this.color != pieceDiagonalRight.color) {
                    validMovies.add(positionDiagonalRight);
                }
            }
        }

        return validMovies;
    }
}