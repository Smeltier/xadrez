package main.java.com.work.chess.exceptions;

public class InvalidPositionException extends IllegalArgumentException {
    public InvalidPositionException (String s) {
        super(s);
    }
}