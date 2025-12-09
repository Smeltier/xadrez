package main.java.com.work.chess.view;

public class MenuView {
    
    private MenuView () {}

    public static void startMenu () {
        MenuView.title("BEM - VINDO AO JOGO DE XADREZ");
        System.out.println("1 - Iniciar nova partida");
        System.out.println("2 - Regras do jogo");
        System.out.println("3 - Sair");
        System.out.print("\nEscolha uma opção: ");
    }
    
    public static void promotionMenu () {
        MenuView.title("PROMOÇÃO DO PEÃO");
        System.out.println("Escolha a peça para promover:");
        System.out.println("1 - Dama (♕)");
        System.out.println("2 - Torre (♖)");
        System.out.println("3 - Cavalo (♘)");
        System.out.println("4 - Bispo (♗)");
        System.out.print("\nOpção: ");
    }

    public static void showRules() {
        MenuView.title("REGRAS E INSTRUÇÕES");
        
        System.out.println("OBJETIVO:");
        System.out.println("  O objetivo é dar Xeque-mate no Rei adversário.");
        System.out.println("  As peças Brancas sempre começam o jogo.\n");

        System.out.println("MOVIMENTAÇÃO DAS PEÇAS:");
        System.out.println("  ♟ PEÃO:   Move-se para frente (1 casa). No primeiro movimento, pode andar 2.");
        System.out.println("            Captura apenas na diagonal. Promoção ao chegar ao fim.");
        System.out.println("  ♜ TORRE:  Move-se em linhas retas (horizontal e vertical).");
        System.out.println("  ♞ CAVALO: Move-se em 'L' (2 casas em uma direção + 1 perpendicular).");
        System.out.println("            É a única peça que pode pular outras.");
        System.out.println("  ♝ BISPO:  Move-se em diagonais livres.");
        System.out.println("  ♛ DAMA:   Combina os movimentos da Torre e do Bispo.");
        System.out.println("  ♚ REI:    Move-se 1 casa em qualquer direção.\n");

        System.out.println("COMO JOGAR:");
        System.out.println("  Digite as coordenadas de ORIGEM e DESTINO.");
        System.out.println("  Exemplo: 'e2 e4' (Move a peça de E2 para E4).");
        System.out.println("  Exemplo: 'a1 h8' (Move a peça de A1 para H8).");
        
        System.out.println("\n[Pressione ENTER para voltar ao menu principal]");
    }

    public static void title (String message) {
        System.out.println("\n===========================================");
        System.out.println("   " + message);
        System.out.println("===========================================");
    }
}