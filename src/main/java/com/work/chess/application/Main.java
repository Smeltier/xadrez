package main.java.com.work.chess.application;

import main.java.com.work.chess.util.ConsoleUtils;

public class Main {
    public static void main(String[] args) {
        ConsoleUtils.defineUTF8();
        ChessApp app = new ChessApp();
        app.start();
    }
}