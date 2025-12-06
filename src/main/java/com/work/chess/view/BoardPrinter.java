package main.java.com.work.chess.view;

import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.model.chess_pieces.Piece;
import main.java.com.work.chess.enums.PieceColor;

public class BoardPrinter {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m"; 
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    private BoardPrinter() {}

    public static void print(Board board) {

        System.out.println("  a b c d e f g h");
        
        for (int row = 8; row >= 1; --row) {
            System.out.print(row + " ");

            for (int col = 1; col <= 8; col++) {
                
                String backgroundColor;
                if ((row + col) % 2 == 0) {
                    backgroundColor = ANSI_BLUE_BACKGROUND;
                } else {
                    backgroundColor = ANSI_WHITE_BACKGROUND;
                }
                
                System.out.print(backgroundColor);
                printPiece(board.getPieceAt(new Position(row, col)));
                System.out.print(ANSI_RESET); 
            }
            
            System.out.println(ANSI_RESET + " " + row); 
        }
        
        System.out.println("  a b c d e f g h");
        System.out.println();
    }

    private static void printPiece(Piece piece) {
        if (piece == null) {
            System.out.print("  "); 
        } else {
            String symbol = piece.getSymbol();
            
            if (piece.getColor() == PieceColor.WHITE) {
                System.out.print("\u001B[1m\u001B[37m" + symbol + " ");
            } else {
                System.out.print(ANSI_BLACK + symbol + " ");
            }
        }
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
}