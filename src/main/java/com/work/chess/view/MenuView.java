package main.java.com.work.chess.view;

public class MenuView {
    private MenuView () {}

    public static void startMenu () {
        MenuView.title("BEM - VINDO AO JOGO XADREZ");
        System.out.print("Escolha uma opção: ");
        System.out.println("1 - Iniciar nova partida");
        System.out.println("2 - Carregar partida");
        System.out.println("3 - Regras do jogo");
        System.out.println("4 - Sair");
    }

    public static void promotionMenu () {
        MenuView.title("ESCOLHA UMA OPÇÃO PARA A PROMOÇÃO DO PEÃO");
        System.out.println("1-Dama");
        System.out.println("2-Torre");
        System.out.println("3-Cavalo");
        System.out.println("4-Bispo");
    }

    private static void title (String message) {
        System.out.println("=================================");
        System.out.println(message);
        System.out.println("=================================");
    }
}