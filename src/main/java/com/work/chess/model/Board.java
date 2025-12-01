package main.java.com.work.chess.model;

import main.java.com.work.chess.model.Piece;;

public class Board {
    private final int BOARDSIZE = 8;
    private Piece[][] board = new Piece[BOARDSIZE][BOARDSIZE];

    public Board () {
    }

    public Piece getPieceAt (Position position) {
        return board[position.getRow()][position.getCol()];
    }

    public void setPieceAt (Position position, Piece piece) {
        board[position.getRow()][position.getCol()] = piece;
    }
}