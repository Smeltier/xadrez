package main.java.com.work.chess.model.chess_pieces;

import java.util.ArrayList;

import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.util.SymbolFactory;
import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.enums.PieceType;
import main.java.com.work.chess.model.Board;

public class King extends Piece {   
    public King (PieceColor color, Position position) {
        super(SymbolFactory.getSymbol(PieceType.KING, color), color, position);
    }

    @Override
    public ArrayList <Position> getValidMoves (Board board) {
        return new ArrayList <Position>();
    }
}