package main.java.com.work.chess.model;

import java.util.ArrayList;

import main.java.com.work.chess.model.Piece;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.util.PieceColor;

public class Pawn extends Piece {
    private boolean isFirstMove;

    public Pawn (String symbol, PieceColor color, Position position) {
        super(symbol, color, position);
        this.isFirstMove = false;
    }

    @Override
    public ArrayList <Position> getValidMoves (Board board) {
        return new ArrayList <Position>();
    }
}