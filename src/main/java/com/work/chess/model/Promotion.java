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
    public boolean canExecute (Board board, Move move) {
        if (!(move.getPiece() instanceof Pawn)) {
            return false;
        }

        int row = move.getDestiny().getRow();
        int boardSize = board.getBoardsize();
        
        if (move.getPiece().getColor() == PieceColor.WHITE && row == boardSize) {
            return true;
        }

        if (move.getPiece().getColor() == PieceColor.BLACK && row == 1) {
            return true;
        }

        return false;
    }

    @Override
    public void execute (Board board, Move move) {
        MenuView.promotionMenu();
        
        @SuppressWarnings("resource") 
        Scanner sc = new Scanner(System.in); 
        
        System.out.print("Escolha a opção: ");
        String input = sc.nextLine();
        
        int option = 1;
        try {
            option = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Promovendo para Dama automaticamente.");
        }
        
        PieceType type = switch (option) {
            case 1 -> PieceType.QUEEN;
            case 2 -> PieceType.ROOK;
            case 3 -> PieceType.KNIGHT;
            case 4 -> PieceType.BISHOP;
            default -> PieceType.QUEEN;
        };

        Piece newPiece = PromotionFactory.create(type, move.getPiece());

        if (newPiece != null) {
            newPiece.setPosition(move.getDestiny());
            
            try {
                board.setPieceAt(move.getDestiny(), newPiece);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao realizar promoção: " + e.getMessage());
            }
        }
    }
}