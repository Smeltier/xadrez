package main.java.com.work.chess.controller;

import java.util.List;

import main.java.com.work.chess.interfaces.ISpecialMove;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Move;

public class PieceMover {

    private PieceMover () {}

    public static void move (Board board, Move move, List<ISpecialMove> specials) {
        ISpecialMove specialMoveToExecute = null;
        
        for (ISpecialMove s : specials) {
            if (s.canExecute(board, move)) {
                specialMoveToExecute = s;
                break;
            }
        }

        applyMove(board, move);

        if (specialMoveToExecute != null) {
            specialMoveToExecute.execute(board, move);
        }
    }   

    private static void applyMove (Board board, Move move) {
        try {
            board.setPieceAt(move.getOrigin(), null);
            move.getPiece().setPosition(move.getDestiny());
            board.setPieceAt(move.getDestiny(), move.getPiece());
        } catch (Exception e) {
            throw new RuntimeException("Erro crítico ao mover peça no tabuleiro: " + e.getMessage());
        }
    }
}