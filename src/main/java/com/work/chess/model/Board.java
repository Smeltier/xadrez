package main.java.com.work.chess.model;

import main.java.com.work.chess.exceptions.InvalidPositionException;
import main.java.com.work.chess.model.chess_pieces.Piece;

public class Board {
    private Integer boardsize;
    private Piece[][] board = new Piece[boardsize][boardsize];
    private Position enPassantVulnerable;

    public Board (Integer size) throws IllegalArgumentException {
        this.setBoardsize(size);
    }

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
        return row >= 0 && row < this.boardsize && col >= 0 && col < this.boardsize;
    }

    public Integer getBoardsize () {
        return boardsize;
    }

    public Position getEnPassantVulnerable () {
        return enPassantVulnerable;
    }

    public void setBoardsize(Integer boardsize) throws IllegalArgumentException {
        if (boardsize <= 0) {
            throw new IllegalArgumentException("Tamanho inválido para o tabuleiro");
        }

        this.boardsize = boardsize;
    }

    public void setEnPassantVulnerable (Position enPassantVulnerable) {
        this.enPassantVulnerable = enPassantVulnerable;
    }
}