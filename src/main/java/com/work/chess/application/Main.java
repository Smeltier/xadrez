package main.java.com.work.chess.application;

import main.java.com.work.chess.controller.Game;
import main.java.com.work.chess.util.ConsoleUtils;

public class Main {
    public static void main(String[] args) {
        ConsoleUtils.defineUTF8();
        Game chessGame = new Game();
        System.out.println("Iniciando Chess Game...");
        chessGame.run();
    }
}