package main.java.com.work.chess.controller;

import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.model.chess_pieces.Bishop;
import main.java.com.work.chess.model.chess_pieces.King;
import main.java.com.work.chess.model.chess_pieces.Knight;
import main.java.com.work.chess.model.chess_pieces.Pawn;
import main.java.com.work.chess.model.chess_pieces.Piece;
import main.java.com.work.chess.model.chess_pieces.Queen;
import main.java.com.work.chess.model.chess_pieces.Rook;
import main.java.com.work.chess.view.BoardPrinter;

public class Game {
    private Board board;
    private boolean isRunning;

    public Game () {
        this.board = new Board();
        this.isRunning = true;
        this.initialSetup();  
    }

    public void run () {
        BoardPrinter.print(board);
    }

    private void initialSetup() {
        PieceColor black = PieceColor.BLACK;
        PieceColor white = PieceColor.WHITE;

        setupPiece(new Rook(white,   new Position(1, 1)));
        setupPiece(new Knight(white, new Position(1, 2)));
        setupPiece(new Bishop(white, new Position(1, 3)));
        setupPiece(new Queen(white,  new Position(1, 4)));
        setupPiece(new King(white,   new Position(1, 5)));
        setupPiece(new Bishop(white, new Position(1, 6)));
        setupPiece(new Knight(white, new Position(1, 7)));
        setupPiece(new Rook(white,   new Position(1, 8)));

        for (int i = 1; i <= 8; i++) {
            setupPiece(new Pawn(white, new Position(2, i)));
        }

        setupPiece(new Rook(black,   new Position(8, 1)));
        setupPiece(new Knight(black, new Position(8, 2)));
        setupPiece(new Bishop(black, new Position(8, 3)));
        setupPiece(new Queen(black,  new Position(8, 4))); 
        setupPiece(new King(black,   new Position(8, 5))); 
        setupPiece(new Bishop(black, new Position(8, 6)));
        setupPiece(new Knight(black, new Position(8, 7)));
        setupPiece(new Rook(black,   new Position(8, 8)));

        for (int i = 1; i <= 8; i++) {
            setupPiece(new Pawn(black, new Position(7, i)));
        }
    }

    private void setupPiece(Piece piece) {
        try {
            board.setPieceAt(piece.getPosition(), piece);
        } catch (Exception e) {}
    }
}