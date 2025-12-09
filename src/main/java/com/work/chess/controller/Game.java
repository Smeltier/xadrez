package main.java.com.work.chess.controller;

import java.util.Scanner;
import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Move;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.model.chess_pieces.Piece;
import main.java.com.work.chess.factories.StandardBoardFactory;
import main.java.com.work.chess.view.BoardPrinter;
import main.java.com.work.chess.view.MenuView;

public class Game {
    private Board board;
    private boolean isRunning;
    private PieceColor currentPlayerColor;
    private Player whitePlayer;
    private Player blackPlayer;
    
    public Game () {
        this.board = StandardBoardFactory.createBoard ();
        this.isRunning = true;
        this.currentPlayerColor = PieceColor.WHITE; 
    }

    public void run () {
        Scanner sc = new Scanner (System.in);
        this.setupPlayers (sc);

        while (isRunning) {
            try {
                processTurn (sc);
            } catch (Exception e) {
                System.out.println (e.getMessage ());
            }
        }
        sc.close ();
        System.out.println ("Fim do Jogo.");
    }

    private void processTurn (Scanner sc) {
        BoardPrinter.print (board);
        
        Player currentPlayer = (this.currentPlayerColor == PieceColor.WHITE) ? whitePlayer : blackPlayer;
        System.out.println ("\nÉ a vez de: " + currentPlayer.getName () + " (" + this.currentPlayerColor + ")");
        
        if (ChessRules.isKingInCheck (board, this.currentPlayerColor)) { 
            System.out.println ("O REI ESTÁ EM XEQUE!"); 
        }

        System.out.print ("Digite o movimento: ");

        try {
            Position[] positions = MoveReader.read (sc); 
            Position from = positions[0];
            Position to = positions[1];

            validateSourcePosition (from);

            Piece piece = board.getPieceAt (from);
            
            if (!ChessRules.isMoveLegal (board, piece, from, to)) {
                System.out.println ("[ERRO]: Movimento ilegal.");
                return;
            }

            Piece capturedPiece = board.getPieceAt (to);
            Move moveExecution = new Move (piece, from, to, capturedPiece);
            PieceMover.move (board, moveExecution);
            
            this.switchTurn ();

        } catch (IllegalArgumentException e) {
            System.out.println ("[ALERTA]: " + e.getMessage ());
        }
    }

    private void validateSourcePosition (Position from) {
        Piece piece = board.getPieceAt (from);
        if (piece == null) {
            throw new IllegalArgumentException ("Não existe peça na posição de origem.");
        }
        if (piece.getColor () != this.currentPlayerColor) {
            throw new IllegalArgumentException ("Essa peça não é sua!");
        }
    }
    
    private void setupPlayers (Scanner sc) {
        MenuView.title ("CONFIGURAÇÃO DA PARTIDA");
        
        System.out.print ("Digite o nome do Jogador 1: ");
        String name1 = sc.nextLine ();
        
        System.out.print ("Digite o nome do Jogador 2: ");
        String name2 = sc.nextLine ();
        
        System.out.println ("\nQuem vai jogar com as BRANCAS (Joga Primeiro)?");
        System.out.println ("1 - " + name1);
        System.out.println ("2 - " + name2);
        System.out.print ("Escolha (1 ou 2): ");
        
        String choice = sc.nextLine ();
        
        if (choice.equals ("2")) {
            this.whitePlayer = new Player (name2, PieceColor.WHITE);
            this.blackPlayer = new Player (name1, PieceColor.BLACK);
            System.out.println ("\nConfigurado: " + name2 + " começa com as Brancas!");
        } else {
            this.whitePlayer = new Player (name1, PieceColor.WHITE);
            this.blackPlayer = new Player (name2, PieceColor.BLACK);
            System.out.println ("\nConfigurado: " + name1 + " começa com as Brancas!");
        }
        
        System.out.println ("Pressione ENTER para iniciar...");
        sc.nextLine ();
    }

    private void switchTurn () {
        this.currentPlayerColor = (this.currentPlayerColor == PieceColor.WHITE) ? PieceColor.BLACK : PieceColor.WHITE;
    }
}