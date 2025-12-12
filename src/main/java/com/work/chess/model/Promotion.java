package main.java.com.work.chess.model;

import java.util.Scanner;

import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.enums.PieceType;
import main.java.com.work.chess.factories.PromotionFactory;
import main.java.com.work.chess.interfaces.ISpecialMove;
import main.java.com.work.chess.model.chess_pieces.Pawn;
import main.java.com.work.chess.model.chess_pieces.Piece;
import main.java.com.work.chess.view.MenuView;

public class Promotion implements ISpecialMove {

    @Override
    public boolean canExecute(Board board, Move move) {
        Piece piece = move.getPiece();
        Position to = move.getDestiny();

        if (!(piece instanceof Pawn)) {
            return false;
        }

        int row = to.getRow();
        int boardSize = board.getBOARDSIZE();
        
        if (piece.getColor() == PieceColor.WHITE && row == boardSize) {
            return true;
        }

        if (piece.getColor() == PieceColor.BLACK && row == 1) {
            return true;
        }

        return false;
    }

    @Override
    public void execute(Board board, Move move) {
        MenuView.promotionMenu();
        
        Scanner sc = new Scanner(System.in); 
        int option = sc.nextInt();
        
        PieceType type = switch (option) {
            case 1 -> PieceType.QUEEN;
            case 2 -> PieceType.ROOK;
            case 3 -> PieceType.KNIGHT;
            case 4 -> PieceType.BISHOP;
            default -> PieceType.QUEEN;
        };

        Piece newPiece = PromotionFactory.create(type, move.getPiece());

        try {
            if (newPiece != null) {
                newPiece.setPosition(move.getDestiny());
                board.setPieceAt(move.getDestiny(), newPiece);
            }
        } catch (Exception e) {
            System.out.println("Erro na Promoção: " + e.getMessage());
        }
    }
}