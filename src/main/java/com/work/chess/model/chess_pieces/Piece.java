package main.java.com.work.chess.model.chess_pieces;

import java.util.ArrayList;

import main.java.com.work.chess.util.PieceColor;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.model.Board;

public abstract class Piece {
    private final String symbol;
    protected final PieceColor color;
    protected Position position;

    public Piece (String symbol, PieceColor color, Position position) {
        this.symbol = symbol;
        this.color = color;
        this.position = position;
    }

    public abstract ArrayList <Position> getValidMoves (Board board);

    public Position getPosition () {
        return this.position;
    }

    public PieceColor getColor() {
        return color;
    }
    
    public String getSymbol () {
        return this.symbol;
    }

    public void setPosition (Position newPosition) {
        this.position = newPosition;
    }
}