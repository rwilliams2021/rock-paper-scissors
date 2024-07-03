package org.game.model.player;

import org.game.enums.Symbol;

/**
 * Abstract class representing a player in the game.
 */
public abstract class Player {
    protected String name;
    protected int wins;
    
    /**
     * Method to choose a symbol for the player.
     * @return The chosen symbol.
     */
    public abstract Symbol chooseSymbol();
    
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
