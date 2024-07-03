package org.game.model;

import org.game.enums.Symbol;

public abstract class Player {
    protected String name;
    protected int wins;
    
    abstract Symbol chooseSymbol();
    
    public String getName() {
        return name;
    }
    
    public int getWins() {
        return wins;
    }
    
    public void incrementWins() {
        wins++;
    }
}
