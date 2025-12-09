package main.java.com.work.chess.util;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class ConsoleUtils {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[1;97m";
    public static final String ANSI_YELLOW = "\u001B[1;33m";
    public static final String ANSI_CYAN = "\u001b[36m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

    private ConsoleUtils () {}
    
    public static void clearScreen () {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
        }
    }

    public static void defineUTF8 () {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("Aviso: Não foi possível definir UTF-8. Os símbolos podem falhar.");
        }
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}