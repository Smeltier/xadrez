package main.java.com.work.chess.model.chess_pieces;

import java.util.ArrayList;

import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.util.SymbolFactory;
import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.enums.PieceType;
import main.java.com.work.chess.model.Board;

public class Bishop extends SlidingPiece {   
    public Bishop (PieceColor color, Position position) {
        super(SymbolFactory.getSymbol(PieceType.BISHOP, color), color, position);
    }

    @Override
    public ArrayList <Position> getValidMoves (Board board) {
        ArrayList <Position> validMoves = new ArrayList<>();

        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, -1, 1};

        for (int direction = 0; direction < 4; direction++) {
            checkMoveTrajectory(validMoves, board, dx[direction], dy[direction]);
        }

        return validMoves;
    }
}