package main.java.com.work.chess.util;

import java.util.ArrayList;
import java.util.List;

import main.java.com.work.chess.interfaces.ISpecialMoves;
import main.java.com.work.chess.model.Promotion;

public class SpecialMovesRegistry {
    private static final ArrayList <ISpecialMoves> specialMoves = new ArrayList<>();   

    static {
        specialMoves.add(new Promotion());
    }

    public static List<ISpecialMoves> getAll() {
        return specialMoves;
    }
}