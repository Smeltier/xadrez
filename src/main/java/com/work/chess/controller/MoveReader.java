package main.java.com.work.chess.controller;

import main.java.com.work.chess.model.Position;

public class MoveReader {

    private MoveReader () {}

    public static Position[] parse (String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Entrada vazia.");
        }
        
        String[] parts = input.trim().split("\\s+");

        if (parts.length != 2) {
            throw new IllegalArgumentException("Entrada inválida. Digite origem e destino (ex: a2 a4).");
        }

        Position from = convertStringToPosition(parts[0]);
        Position to = convertStringToPosition(parts[1]);

        return new Position[] { from, to };
    }

    private static Position convertStringToPosition (String s) {
        if (s.length() != 2) {
            throw new IllegalArgumentException("Coordenada inválida: " + s);
        }

        s = s.toLowerCase();

        char colChar = s.charAt(0);
        char rowChar = s.charAt(1);

        if (colChar < 'a' || colChar > 'h' || rowChar < '1' || rowChar > '8') {
            throw new IllegalArgumentException("Coordenada fora do tabuleiro: " + s);
        }

        int col = colChar - 'a' + 1;
        int row = Character.getNumericValue(rowChar);

        return new Position(row, col);
    }
}