package org.game.model.player;

import org.game.choosestrategies.UserChooseStrategy;
import org.game.enums.Symbol;
import org.game.view.InputProvider;

/**
 * Represents the user player.
 */
public class User extends Player {
    
    private InputProvider inputProvider;
    
    public User(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }
    
    public User() {
    }
    
    public void setInputProvider(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }
    
    @Override
    public Symbol chooseSymbol() {
        return new UserChooseStrategy(inputProvider).chooseSymbol();
    }
}
