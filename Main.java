import main.java.com.work.chess.view.BoardPrinter;
import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Position;
import main.java.com.work.chess.model.chess_pieces.Pawn;
import main.java.com.work.chess.util.ConsoleUtils;
import main.java.com.work.chess.enums.PieceColor;

public class Main {
    public static void main (String[] args) {
        Board board = new Board();

        Pawn pawn = new Pawn("♘", PieceColor.BLACK, new Position(1, 1));

        try {
            board.setPieceAt(pawn.getPosition(), pawn);
        } catch (Exception e) {}

        ConsoleUtils.clearScreen();
        BoardPrinter.print(board);
    }
}