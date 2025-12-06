package main.java.com.work.chess.controller;

import java.util.Scanner;

import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.model.chess_pieces.Piece;
import main.java.com.work.chess.model.chess_pieces.Pawn;
import main.java.com.work.chess.enums.PieceType;
import main.java.com.work.chess.interfaces.ISpecialMoves;

public class Promotion implements ISpecialMoves {

    public boolean canExecute (Board board, Piece piece, Position position) {
        if (!(piece instanceof Pawn)) {
            return false;
        }

        int row = position.getRow();
        
        if (piece.getColor() == PieceColor.WHITE && row == board.getBOARDSIZE()) {
            return true;
        }

        if (piece.getColor() == PieceColor.BLACK && row == 1) {
            return true;
        }

        return false;
    }

    // Rainha, Cavalo, Torre e Bispo
    public void execute (Board board, Piece piece, Position position) {
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

        Piece newPiece = PromotionFactory.create(type, piece);

        try {
            board.setPieceAt(piece.getPosition(), newPiece);
        } catch (Exception e) {}
    }
}
