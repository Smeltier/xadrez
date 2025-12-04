package main.java.com.work.chess.model;

public class Player {
    private final String name;
    private final Integer id;
    
    public Player (String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName () {
        return this.name;
    }

    public Integer getID () {
        return this.id;
    }
}