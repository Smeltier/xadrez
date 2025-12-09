package main.java.com.work.chess.model;

import java.util.Objects; // Necessário para hashCode

public class Position {
    private final int row;
    private final int col;

    public Position (int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Position other = (Position) obj;
        return row == other.row && col == other.col;
    }

    @Override
    public int hashCode () {
        return Objects.hash(row, col);
    }
    
    @Override
    public String toString () {
        char file = (char) ('A' + col - 1); 
        return "" + file + row;
    }

    public int getCol () {
        return col;
    }

    public int getRow () {
        return row;
    }
}