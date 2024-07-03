package org.game.model.player;

import org.game.constants.MessageConstants;
import org.game.enums.Symbol;
import org.game.choosestrategies.UserChooseStrategy;
import org.game.view.InputProvider;

/**
 * Represents the user player.
 */
public class User extends Player {
    
    private final InputProvider inputProvider;
    
    public User(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
        name = inputProvider.getInput(MessageConstants.ENTER_NAME_MSG);
    }
    
    @Override
    public Symbol chooseSymbol() {
        return new UserChooseStrategy(inputProvider).chooseSymbol();
    }
}
