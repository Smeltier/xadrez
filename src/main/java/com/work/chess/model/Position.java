package main.java.com.work.chess.model;

public class Position {
    private final int row;
    private final int col;

    /**
      * Cria a representação de uma posição.
      * 
      */
    public Position (int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public boolean equals (Object obj) {
        return true;
    }
}