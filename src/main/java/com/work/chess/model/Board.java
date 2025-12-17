package main.java.com.work.chess.model;

import main.java.com.work.chess.exceptions.InvalidPositionException;
import main.java.com.work.chess.model.chess_pieces.Piece;

public class Board {
    private final Integer BOARDSIZE = 8;
    private Piece[][] board = new Piece[BOARDSIZE][BOARDSIZE];
    private Position enPassantVulnerable;

    public Board () {}

    public Piece getPieceAt (Position position) {
        return board[position.getRow() - 1][position.getCol() - 1];
    }

    public void setPieceAt (Position position, Piece piece) {
        if (!isOnLimits(position)) {
            throw new InvalidPositionException("Posição fora dos limites do tabuleiro.");
        }
        board[position.getRow() - 1][position.getCol() - 1] = piece;
    }
    
    public boolean isOnLimits (Position position) {
        int row = position.getRow() - 1;
        int col = position.getCol() - 1;
        return row >= 0 && row < this.BOARDSIZE && col >= 0 && col < this.BOARDSIZE;
    }

    public Integer getBOARDSIZE () {
        return BOARDSIZE;
    }

    public Position getEnPassantVulnerable () {
        return enPassantVulnerable;
    }

    public void setEnPassantVulnerable (Position enPassantVulnerable) {
        this.enPassantVulnerable = enPassantVulnerable;
    }
}