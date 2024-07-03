package org.game.model;

import org.game.constants.Constants;
import org.game.enums.Symbol;
import org.game.exceptions.QuitGameException;
import org.game.utils.InputProvider;

public class User extends Player {
    private final InputProvider inputProvider;
    
    public User(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
        name = inputProvider.getInput(Constants.ENTER_NAME_MSG);
    }
    
    @Override
    public Symbol chooseSymbol() throws QuitGameException {
        String userChoice = inputProvider.getInput(Constants.CHOOSE_SYMBOL_MSG);
        if (userChoice.equalsIgnoreCase(Constants.QUIT)) {
            throw new QuitGameException("Game quit by user");
        }
        return Symbol.fromStringSymbol(userChoice.toLowerCase());
    }
}
