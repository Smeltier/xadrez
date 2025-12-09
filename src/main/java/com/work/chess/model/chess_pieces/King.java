package main.java.com.work.chess.model.chess_pieces;

import java.util.ArrayList;

import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.enums.PieceType;
import main.java.com.work.chess.factories.SymbolFactory;
import main.java.com.work.chess.model.Board;

public class King extends Piece {   
    public King (PieceColor color, Position position) {
        super (SymbolFactory.getSymbol (PieceType.KING, color), color, position);
    }

    @Override
    public ArrayList <Position> getValidMoves (Board board) {
        ArrayList <Position> validMoves = new ArrayList <> ();
        
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            Position target = new Position (position.getRow () + dr[i], position.getCol () + dc[i]);

            if (board.isOnLimits (target)) {
                Piece piece = board.getPieceAt (target);
                if (piece == null || piece.getColor () != this.color) {
                    validMoves.add (target);
                }
            }
        }
        
        return validMoves;
    }
}