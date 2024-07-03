package org.game.controller;

import org.game.model.Game;

/**
 * Singleton class responsible for managing the game flow.
 */
public class GameManager {
    private static GameManager instance;
    
    private GameManager() {}
    
    /**
     * Returns the single instance of GameManager.
     */
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }
    
    /**
     * Starts the game.
     * @param game The Game object containing the game logic.
     */
    public void startGame(Game game) {
        game.play();
    }
}

