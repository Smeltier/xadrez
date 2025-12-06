package main.java.com.work.chess.model;

import main.java.com.work.chess.enums.PieceColor;

public class Player {
    private final String name;
    private PieceColor color;
    
    public Player (String name) {
        this.name = name;
    }

    public Player (String name, PieceColor color) {
        this.name = name;
        this.color = color;
    }

    public String getName () {
        return this.name;
    }

    public PieceColor getColor () {
        return this.color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }
}