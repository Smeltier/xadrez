package main.java.com.work.chess.controller;

import main.java.com.work.chess.enums.PieceColor;
import main.java.com.work.chess.factories.StandardBoardFactory;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Move;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.model.chess_pieces.Piece;
import main.java.com.work.chess.util.ConsoleUtils;
import main.java.com.work.chess.util.SpecialMovesRegistry;
import main.java.com.work.chess.view.MenuView;
import main.java.com.work.chess.interfaces.IUserInterface;

public class Game {
    private final Board board;
    private final IUserInterface ui;
    private boolean isRunning;
    private PieceColor currentPlayerColor;
    private Player whitePlayer;
    private Player blackPlayer;
    
    public Game (IUserInterface ui) {
        this.board = StandardBoardFactory.createBoard();
        this.ui = ui;
        this.isRunning = true;
        this.currentPlayerColor = PieceColor.WHITE; 
    }

    public void run () {
        this.setupPlayers();

        while (isRunning) {
            try {
                processTurn();
            } catch (Exception e) {
                ui.showError("Erro inesperado: " + e.getMessage());
            }
        }

        ui.showMessage("Fim do Jogo.");
    }

    private void processTurn () {
        ui.showBoard(board);
        Player currentPlayer = (this.currentPlayerColor == PieceColor.WHITE) ? whitePlayer : blackPlayer;

        if (ChessRules.isCheckMate(board, currentPlayerColor)) {
            ui.showMessage("\nXEQUE-MATE!");
            ui.showMessage("Vencedor: " + ((currentPlayerColor == PieceColor.WHITE) ? blackPlayer.getName() : whitePlayer.getName()));
            this.isRunning = false;
            return;
        }

        if (ChessRules.isStalemate(board, currentPlayerColor)) {
            ui.showMessage("\nEMPATE POR AFOGAMENTO (STALEMATE)!");
            this.isRunning = false;
            return;
        }
        
        if (ChessRules.isKingInCheck(board, this.currentPlayerColor)) { 
            ui.showMessage("\nO REI ESTÁ EM XEQUE!"); 
        }

        ui.showMessage("\nÉ a vez de: " + currentPlayer.getName() + " (" + this.currentPlayerColor + ")");

        try {
            Position[] positions = ui.readMove();
            Position from = positions[0];
            Position to = positions[1];

            validateSourcePosition(from);

            Piece piece = board.getPieceAt(from);
            Piece capturedPiece = board.getPieceAt(to);

            Move move = new Move(piece, from, to, capturedPiece);
            
            if (!ChessRules.isMoveLegal(board, move)) {
                ui.showError("Movimento ilegal ou coloca seu rei em risco.");
                return;
            }

            PieceMover.move(board, move, SpecialMovesRegistry.getAll());
            
            if (piece instanceof main.java.com.work.chess.model.chess_pieces.Pawn) {
                int rowDiff = Math.abs(to.getRow() - from.getRow());
                
                if (rowDiff == 2) {
                    int middleRow = (from.getRow() + to.getRow()) / 2;
                    Position enPassantTarget = new Position(middleRow, from.getCol());
                    board.setEnPassantVulnerable(enPassantTarget);
                } else {
                    board.setEnPassantVulnerable(null);
                }
            } else {
                board.setEnPassantVulnerable(null);
            }
            
            this.switchTurn();

        } catch (IllegalArgumentException e) {
            ui.showError(e.getMessage());
        }
    }

    private void validateSourcePosition (Position from) {
        Piece piece = board.getPieceAt(from);
        
        if (piece == null) {
            throw new IllegalArgumentException("Não existe peça na posição de origem.");
        }
        
        if (piece.getColor() != this.currentPlayerColor) {
            throw new IllegalArgumentException("Essa peça não é sua!");
        }
    }
    
    private void setupPlayers () {
        ConsoleUtils.clearScreen();

        MenuView.title("CONFIGURAÇÃO DA PARTIDA");
        
        String name1 = ui.readInput("Digite o nome do Jogador 1: ");
        String name2 = ui.readInput("Digite o nome do Jogador 2: ");
        
        ui.showMessage("\nQuem vai jogar com as BRANCAS (Joga Primeiro)?");
        ui.showMessage("1 - " + name1);
        ui.showMessage("2 - " + name2);
        
        String choice = ui.readInput("Escolha (1 ou 2): ");
        
        if (choice.equals("2")) {
            this.whitePlayer = new Player(name2, PieceColor.WHITE);
            this.blackPlayer = new Player(name1, PieceColor.BLACK);
            ui.showMessage("\nConfigurado: " + name2 + " começa com as Brancas!");
        } else {
            this.whitePlayer = new Player(name1, PieceColor.WHITE);
            this.blackPlayer = new Player(name2, PieceColor.BLACK);
            ui.showMessage("\nConfigurado: " + name1 + " começa com as Brancas!");
        }
        
        ui.readInput("Pressione ENTER para iniciar...");
        ConsoleUtils.clearScreen();
    }

    private void switchTurn () {
        this.currentPlayerColor = (this.currentPlayerColor == PieceColor.WHITE) ? PieceColor.BLACK : PieceColor.WHITE;
    }
}