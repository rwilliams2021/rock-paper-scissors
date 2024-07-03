package org.game.model;

import org.game.enums.Symbol;
import org.game.exceptions.QuitGameException;

public abstract class Player {
    protected String name;
    protected int wins;
    
    public abstract Symbol chooseSymbol() throws QuitGameException;
    
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
