package org.game.controller;

import org.game.model.Game;

public class GameManager {
    private static GameManager instance;
    
    private GameManager() {}
    
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }
    
    public void startGame(Game game) {
        game.play();
    }
}

