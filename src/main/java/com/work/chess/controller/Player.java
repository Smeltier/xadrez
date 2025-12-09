package main.java.com.work.chess.controller;

import java.util.Objects;

import main.java.com.work.chess.enums.PieceColor;

public class Player {
    private final String name;
    private final PieceColor color;
    
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

    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Player other = (Player) obj;
        return Objects.equals(name, other.name) && color == other.color;
    }

    @Override
    public int hashCode () {
        return Objects.hash(name, color);
    }

    @Override
    public String toString() {
        return name + " (" + (color != null ? color.toString() : "Cor Indefinida") + ")";
    }
}