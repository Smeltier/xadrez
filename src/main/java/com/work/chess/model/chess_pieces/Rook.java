package main.java.com.work.chess.model.chess_pieces;

import java.util.ArrayList;

import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.util.SymbolFactory;
import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.enums.PieceType;
import main.java.com.work.chess.model.Board;

public class Rook extends SlidingPiece {   
    public Rook (PieceColor color, Position position) {
        super(SymbolFactory.getSymbol(PieceType.ROOK, color), color, position);
    }

    @Override
    public ArrayList <Position> getValidMoves (Board board) {
        ArrayList <Position> validMoves = new ArrayList<>();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int direction = 0; direction < 4; direction++) {
            checkMoveTrajectory(validMoves, board, dx[direction], dy[direction]);
        }

        return validMoves;
    }
}