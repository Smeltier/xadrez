package main.java.com.work.chess.model;

import java.util.Objects;

import main.java.com.work.chess.model.chess_pieces.Piece;

public class Move {
    public final Piece piece;
    public final Piece capturedPiece;
    public final Position from;
    public final Position to;

    public Move(Piece piece, Position from, Position to, Piece capturedPiece) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.capturedPiece = capturedPiece;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Move other = (Move) obj;
        return Objects.equals(piece, other.piece) && 
            Objects.equals(from, other.from) && 
            Objects.equals(to, other.to) &&
            Objects.equals(capturedPiece, other.capturedPiece);
    }

    @Override
    public int hashCode () {
        return Objects.hash(piece, from, to, capturedPiece);
    }

    @Override
    public String toString () {
        return piece.getSymbol() + " de " + from.toString() + " para " + to.toString();
    }
}