package main.java.com.work.chess.util;

import java.util.ArrayList;
import java.util.List;

import main.java.com.work.chess.interfaces.ISpecialMove;
import main.java.com.work.chess.model.Castling;
import main.java.com.work.chess.model.EnPassant;
import main.java.com.work.chess.model.Promotion;

public class SpecialMovesRegistry {
    private static final ArrayList <ISpecialMove> specialMoves = new ArrayList<>();   

    static {
        specialMoves.add(new Promotion());
        specialMoves.add(new EnPassant());
        specialMoves.add(new Castling());
    }

    public static List<ISpecialMove> getAll() {
        return specialMoves;
    }
}