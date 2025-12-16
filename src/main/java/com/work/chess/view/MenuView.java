package main.java.com.work.chess.view;

import main.java.com.work.chess.interfaces.IUserInterface;
import main.java.com.work.chess.util.ConsoleUtils;

public class MenuView {

    private static IUserInterface ui;
    
    private MenuView () {}

    public static void setUI (IUserInterface newUI) {
        MenuView.ui = newUI;
    }

    public static void startMenu () {
        ConsoleUtils.clearScreen();
        title("BEM - VINDO AO JOGO DE XADREZ");
        ui.showMessage("1 - Iniciar nova partida");
        ui.showMessage("2 - Regras do jogo");
        ui.showMessage("3 - Sair");
        ui.showMessage("Escolha uma opção:");
    }
    
    public static void promotionMenu () {
        ConsoleUtils.clearScreen();
        title("PROMOÇÃO DO PEÃO");
        ui.showMessage("Escolha a peça para promover:");
        ui.showMessage("1 - Dama (♕)");
        ui.showMessage("2 - Torre (♖)");
        ui.showMessage("3 - Cavalo (♘)");
        ui.showMessage("4 - Bispo (♗)");
    }

    public static void showRules () {
        ConsoleUtils.clearScreen();
        title("REGRAS E INSTRUÇÕES");
        
        ui.showMessage("OBJETIVO:");
        ui.showMessage("  O objetivo é dar Xeque-mate no Rei adversário.");
        ui.showMessage("  As peças Brancas sempre começam o jogo.\n");

        ui.showMessage("MOVIMENTAÇÃO DAS PEÇAS:");
        ui.showMessage("  ♟ PEÃO:   Move-se para frente (1 casa). No primeiro movimento, pode andar 2.");
        ui.showMessage("            Captura apenas na diagonal. Promoção ao chegar ao fim.");
        ui.showMessage("  ♜ TORRE:  Move-se em linhas retas (horizontal e vertical).");
        ui.showMessage("  ♞ CAVALO: Move-se em 'L' (2 casas em uma direção + 1 perpendicular).");
        ui.showMessage("            É a única peça que pode pular outras.");
        ui.showMessage("  ♝ BISPO:  Move-se em diagonais livres.");
        ui.showMessage("  ♛ DAMA:   Combina os movimentos da Torre e do Bispo.");
        ui.showMessage("  ♚ REI:    Move-se 1 casa em qualquer direção.\n");

        ui.showMessage("COMO JOGAR:");
        ui.showMessage("  Digite as coordenadas de ORIGEM e DESTINO.");
        ui.showMessage("  Exemplo: 'e2 e4' (Move a peça de E2 para E4).");
        ui.showMessage("  Exemplo: 'a1 h8' (Move a peça de A1 para H8).");
    }

    public static void title (String message) {
        ui.showMessage("\n===========================================");
        ui.showMessage("   " + message);
        ui.showMessage("===========================================");
    }
}