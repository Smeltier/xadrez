package main.java.com.work.chess.application;

import main.java.com.work.chess.controller.Game;
import main.java.com.work.chess.interfaces.IUserInterface;
import main.java.com.work.chess.view.ConsoleUI;
import main.java.com.work.chess.view.MenuView;

public class ChessApp {

    public void start () {
        IUserInterface ui = new ConsoleUI();
        boolean inMenu = true;

        MenuView.setUI(ui);

        while (inMenu) {
            MenuView.startMenu();
            String option = ui.readInput("");

            switch (option) {
                case "1" -> {
                    Game game = new Game(ui);
                    game.run(); 
                }
                case "2" -> {
                    MenuView.showRules();
                    ui.readInput("Pressione ENTER para voltar...");
                }
                case "3" -> {
                    ui.showMessage("Saindo...");
                    inMenu = false;
                }
                
                default -> ui.showError("Opção inválida.");
            }
        }

        ui.close();
    }
}