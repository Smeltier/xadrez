package main.java.com.work.chess.view;

import java.util.Scanner;

import main.java.com.work.chess.controller.MoveReader;
import main.java.com.work.chess.interfaces.IUserInterface;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Position;

public class ConsoleUI implements IUserInterface {
    private final Scanner sc;

    public ConsoleUI () {
        this.sc = new Scanner(System.in);
    }

    @Override
    public void showBoard (Board board) {
        BoardPrinter.print(board);
    }

    @Override
    public void showMessage (String message) {
        System.out.println(message);
    }

    @Override
    public void showMessageWithTimming (String message, int delay) {
        System.out.println(message);

        try {
            Thread.sleep(delay);
        } catch (Exception e) {}
    }

    @Override
    public void showError (String error) {
        System.out.println("[ERRO]: " + error);
    }

    @Override
    public String readInput (String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    @Override
    public Position[] readMove () {
        System.out.print("Digite o movimento: ");
        String input = sc.nextLine();
        return MoveReader.parse(input);
    }

    @Override
    public void close () {
        sc.close();
    }
}