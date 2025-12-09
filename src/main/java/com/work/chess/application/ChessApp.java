package main.java.com.work.chess.application;

import java.util.Scanner;
import main.java.com.work.chess.controller.Game;
import main.java.com.work.chess.view.MenuView;

public class ChessApp {

    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean inMenu = true;

        while (inMenu) {
            MenuView.startMenu();
            String option = sc.nextLine().trim();

            switch (option) {
                case "1" -> {
                    Game game = new Game();
                    game.run(); 
                }
                case "2" -> {
                    MenuView.showRules();
                    System.out.println("Pressione ENTER para voltar...");
                    sc.nextLine();
                }
                case "3" -> {
                    System.out.println("Saindo...");
                    inMenu = false;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }
}