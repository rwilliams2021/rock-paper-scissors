package org.game.model.player;

import org.game.constants.Constants;
import org.game.enums.Symbol;
import org.game.exceptions.QuitGameException;
import org.game.choosestrategies.UserChooseStrategy;
import org.game.view.InputProvider;

public class User extends Player {
    
    private final InputProvider inputProvider;
    
    public User(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
        name = inputProvider.getInput(Constants.ENTER_NAME_MSG);
    }
    
    @Override
    public Symbol chooseSymbol() throws QuitGameException {
        return new UserChooseStrategy(inputProvider).chooseSymbol();
    }
}
