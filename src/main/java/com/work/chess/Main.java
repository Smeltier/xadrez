package main.java.com.work.chess;

import main.java.com.work.chess.view.BoardPrinter;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.util.ConsoleUtils;

public class Main {
    public static void main (String[] args) {
        // Game game = new Game();
        // game.run();    

        Board board = new Board();
        ConsoleUtils.clearScreen();
        BoardPrinter.print(board);
    }



    System.out.println("=================================");
         System.out.println("ESCOLHA UMA OPÇÃO PARA A PROMOÇÃO DO PEÃO")
         System.out.println("1-Dama");
         System.out.println("2-Torre");
         System.out.println("3-Cavalo");
         System.out.println("4-Bispo");
       
}