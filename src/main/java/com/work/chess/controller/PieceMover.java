package main.java.com.work.chess.controller;

import java.util.List;

import main.java.com.work.chess.interfaces.ISpecialMoves;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Move;
import main.java.com.work.chess.model.Promotion;
import main.java.com.work.chess.model.EnPassant;
import main.java.com.work.chess.model.Castling;

public class PieceMover {

    private static final List<ISpecialMoves> specials = List.of(
        new Promotion(),
        new EnPassant(),
        new Castling()
    );

    private PieceMover() {}

    public static void move(Board board, Move move) {
        applyMove(board, move);
        for (ISpecialMoves s : specials) {
            if (s.canExecute(board, move)) {
                s.execute(board, move);
            }
        }
    }   

    private static void applyMove(Board board, Move move) {
        try {
            board.setPieceAt(move.from, null);
            move.piece.setPosition(move.to);
            board.setPieceAt(move.to, move.piece);
            
        } catch (Exception e) {
            throw new RuntimeException("Erro crítico ao mover peça no tabuleiro: " + e.getMessage());
        }
    }
}