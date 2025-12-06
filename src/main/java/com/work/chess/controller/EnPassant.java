package main.java.com.work.chess.controller;

import main.java.com.work.chess.interfaces.ISpecialMoves;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.model.chess_pieces.Piece;

public class EnPassant implements ISpecialMoves {
    public boolean canExecute (Board board, Piece piece, Position position) {
        return true;
    }

    public void execute (Board board, Piece piece, Position position) {
    }
}
