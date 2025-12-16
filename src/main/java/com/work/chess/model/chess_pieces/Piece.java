package main.java.com.work.chess.model.chess_pieces;

import java.util.Objects; 
import java.util.ArrayList;

import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.model.Board;

public abstract class Piece {
    private final String symbol;
    protected final PieceColor color;
    protected Position position;
    protected int moveCount = 0;

    public Piece (String symbol, PieceColor color, Position position) {
        this.symbol = symbol;
        this.color = color;
        this.position = position;
    }

    public abstract ArrayList <Position> getValidMoves (Board board);

    public boolean isFirstMove () {
        return moveCount == 0;
    }

    public void decreaseMoveCount () {
        if (this.moveCount > 0) {
            this.moveCount--;
        }
    }

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
        this.moveCount++;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Piece other = (Piece) obj;
        return Objects.equals(this.getClass(), other.getClass()) && 
            this.color == other.color &&
            Objects.equals(this.position, other.position);
    }

    @Override
    public int hashCode () {
        return Objects.hash(getClass(), color, position); 
    }

    @Override
    public String toString () {
        return color.name() + " " + getClass().getSimpleName() + " em " + position;
    }
}