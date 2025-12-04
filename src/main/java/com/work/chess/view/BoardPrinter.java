package main.java.com.work.chess.view;

import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Piece;
import main.java.com.work.chess.model.Position;

public class BoardPrinter {
    private BoardPrinter () {}

    public static void print (Board board) {
        System.out.println();
        
        for (int row = 8; row >= 1; --row) {
            System.out.print(row + " ");

            for (int col = 1; col <= 8; col++) {
                Piece piece = board.getPieceAt(new Position(row, col));
                
                if (piece == null) {
                    System.out.print("." + " ");
                    continue;
                }
                
                String symbol = piece.getSymbol();

                if (symbol == null) {
                    System.out.print("." + " ");
                } else {
                    System.out.print(symbol + " ");
                }
            }
            
            System.out.println();
        }

        System.out.println("  a b c d e f g h");
        
        System.out.println();
    }
}