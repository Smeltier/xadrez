package main.java.com.work.chess.factories;

import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.model.chess_pieces.*;

public class StandardBoardFactory {

    public static Board createBoard () {
        try {
            Board board = new Board (8);
            setupSide (board, PieceColor.WHITE);
            setupSide (board, PieceColor.BLACK);
            return board;
        } catch (Exception e) {}

        return null;
    }

    private static void setupSide (Board board, PieceColor color) {
        int mainRow = (color == PieceColor.WHITE) ? 1 : 8;
        int pawnRow = (color == PieceColor.WHITE) ? 2 : 7;

        try {
            board.setPieceAt (new Position (mainRow, 1), new Rook (color, new Position (mainRow, 1)));
            board.setPieceAt (new Position (mainRow, 2), new Knight (color, new Position (mainRow, 2)));
            board.setPieceAt (new Position (mainRow, 3), new Bishop (color, new Position (mainRow, 3)));
            board.setPieceAt (new Position (mainRow, 4), new Queen (color, new Position (mainRow, 4)));
            board.setPieceAt (new Position (mainRow, 5), new King (color, new Position (mainRow, 5)));
            board.setPieceAt (new Position (mainRow, 6), new Bishop (color, new Position (mainRow, 6)));
            board.setPieceAt (new Position (mainRow, 7), new Knight (color, new Position (mainRow, 7)));
            board.setPieceAt (new Position (mainRow, 8), new Rook (color, new Position (mainRow, 8)));

            for (int i = 1; i <= 8; i++) {
                board.setPieceAt (new Position (pawnRow, i), new Pawn (color, new Position (pawnRow, i)));
            }
            
        } catch (Exception e) {
            throw new RuntimeException (e.getMessage ());
        }
    }
}