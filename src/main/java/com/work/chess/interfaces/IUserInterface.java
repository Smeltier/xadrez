package main.java.com.work.chess.interfaces;

import main.java.com.work.chess.model.Board;
import main.java.com.work.chess.model.Position;

public interface IUserInterface {
    void showBoard (Board board);
    void showMessage (String message);
    void showMessageWithTimming (String message, int delay);
    void showError (String error);
    String readInput (String prompt);
    Position[] readMove ();
    void close ();
}