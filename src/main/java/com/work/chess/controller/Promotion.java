package main.java.com.work.chess.controller;

import java.util.Scanner;

import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Move;
import main.java.com.work.chess.model.chess_pieces.Piece;
import main.java.com.work.chess.model.chess_pieces.Pawn;
import main.java.com.work.chess.enums.PieceType;
import main.java.com.work.chess.interfaces.ISpecialMove;

public class Promotion implements ISpecialMove {

    public boolean canExecute (Board board, Move move) {
        if (!(move.getPiece() instanceof Pawn)) {
            return false;
        }

        int row = move.getOrigin().getRow();
        
        if (move.getPiece().getColor() == PieceColor.WHITE && row == board.getBOARDSIZE()) {
            return true;
        }

        if (move.getPiece().getColor() == PieceColor.BLACK && row == 1) {
            return true;
        }

        return false;
    }

    public void execute (Board board, Move move) {
        // Menu.printPromotionMessage();
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        
        PieceType type = switch (option) {
            case 1 -> PieceType.QUEEN;
            case 2 -> PieceType.KNIGHT;
            case 3 -> PieceType.ROOK;
            case 4 -> PieceType.BISHOP;
            default -> PieceType.QUEEN;
        };

        Piece newPiece = PromotionFactory.create(type, move.getPiece());

        try {
            board.setPieceAt(move.getPiece().getPosition(), newPiece);
        } catch (Exception e) {}
    }
}
