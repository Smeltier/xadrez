package main.java.com.work.chess.model.chess_pieces;

import java.util.ArrayList;

import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.util.PieceColor;

public class King extends Piece {   
    public King (String symbol, PieceColor color, Position position) {
        super(symbol, color, position);
    }

    @Override
    public ArrayList <Position> getValidMoves (Board board) {
        return new ArrayList <Position>();
    }
}