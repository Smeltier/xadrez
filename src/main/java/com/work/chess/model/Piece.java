package main.java.com.work.chess.model;

import java.util.List;

public abstract class Piece {
    private final String symbol;
    private final boolean white;
    private Position position;

    public Piece (String symbol, boolean isWhite, Position position) {
        this.symbol = symbol;
        this.white = isWhite;
        this.position = position;
    }

    public abstract List <Position> getValidMoves (Board board);

    public boolean isWhite () {
        return this.white;
    }

    public Position getPosition () {
        return this.position;
    }

    public void setPosition (Position newPosition) {
        this.position = newPosition;
    }

    public String getSymbol () {
        return this.symbol;
    }
}