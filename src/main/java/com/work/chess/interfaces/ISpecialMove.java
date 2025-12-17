package main.java.com.work.chess.interfaces;

import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Move;

public interface ISpecialMove {
    boolean canExecute (Board board, Move move);
    void execute (Board board, Move move);
}