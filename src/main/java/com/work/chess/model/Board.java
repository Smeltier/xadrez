package main.java.com.work.chess.model;

import java.security.InvalidParameterException;

import main.java.com.work.chess.model.chess_pieces.Piece;

public class Board {
    private final int BOARDSIZE = 8;
    private Piece[][] board = new Piece[BOARDSIZE][BOARDSIZE];

    public Board () {}

    public Piece getPieceAt (Position position) {
        return board[position.getRow() - 1][position.getCol() - 1];
    }

    public void setPieceAt (Position position, Piece piece) throws Exception {
        if (!isOnLimits(position)) {
            throw new InvalidParameterException("Posição fora dos limites do tabuleiro.");
        }
        board[position.getRow()][position.getCol()] = piece;
    }
    
    public boolean isOnLimits (Position position) {
        int row = position.getRow();
        int col = position.getCol();
        return row >= 0 && row < this.BOARDSIZE && col >= 0 && row < this.BOARDSIZE;
    }

    public int getBOARDSIZE() {
        return BOARDSIZE;
    }
}