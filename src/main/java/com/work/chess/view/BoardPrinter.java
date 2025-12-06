package main.java.com.work.chess.view;

import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.model.chess_pieces.Piece;
import main.java.com.work.chess.util.ConsoleUtils;
import main.java.com.work.chess.enums.PieceColor;

public class BoardPrinter {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[1;97m";
    public static final String ANSI_YELLOW = "\u001B[1;33m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

    private BoardPrinter() {}

    public static void print(Board board) {
        ConsoleUtils.clearScreen();

        System.out.println("   a  b  c  d  e  f  g  h");
        
        for (int row = 8; row >= 1; --row) {
            System.out.print(row + " ");

            for (int col = 1; col <= 8; col++) {
                
                String backgroundColor;
                
                if ((row + col) % 2 == 0) {
                    backgroundColor = ANSI_PURPLE_BACKGROUND;
                } else {
                    backgroundColor = ANSI_BLACK_BACKGROUND;
                }
                
                printPiece(board.getPieceAt(new Position(row, col)), backgroundColor);
            }
            
            System.out.println(ANSI_RESET + " " + row); 
        }
        
        System.out.println("   a  b  c  d  e  f  g  h");
        System.out.println();
    }

    private static void printPiece(Piece piece, String background) {
        if (piece == null) {
            System.out.print(background + "   " + ANSI_RESET);
        } else {
            if (piece.getColor() == PieceColor.WHITE) {
                System.out.print(background + ANSI_WHITE + " " + piece.getSymbol() + " " + ANSI_RESET);
            } else {
                System.out.print(background + ANSI_YELLOW + " " + piece.getSymbol() + " " + ANSI_RESET);
            }
        }
    }
}