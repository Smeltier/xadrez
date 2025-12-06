package main.java.com.work.chess.interfaces;

import main.java.com.work.chess.model.chess_pieces.Piece;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Position;

public interface ISpecialMoves {
    public boolean canExecute (Board board, Piece piece, Position position);
    public void execute (Board board, Piece piece, Position position);
}