package main.java.com.work.chess.model;

import java.util.Objects;

import main.java.com.work.chess.model.chess_pieces.Piece;

public class Move {
    private final Piece piece;
    private final Piece capturedPiece;
    private final Position from;
    private final Position to;

    public Move(Piece piece, Position from, Position to, Piece capturedPiece) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.capturedPiece = capturedPiece;
    }

    public Piece getCapturedPiece() {
        return capturedPiece;
    }

    public Position getOrigin() {
        return from;
    }

    public Piece getPiece() {
        return piece;
    }

    public Position getDestiny() {
        return to;
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