package org.game.model;

import org.game.constants.Constants;
import org.game.enums.Symbol;
import org.game.utils.InputProvider;

public class User extends Player {
    private final InputProvider inputProvider;
    
    public User(String name, InputProvider inputProvider) {
        this.inputProvider = inputProvider;
        this.name = name;
    }
    
    public User(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
        name = inputProvider.getInput(Constants.ENTER_NAME_MSG);
    }
    
    @Override
    public Symbol chooseSymbol() {
        String userChoice = inputProvider.getInput(Constants.CHOOSE_SYMBOL_MSG);
        return Symbol.fromStringSymbol(userChoice.toLowerCase());
    }
}
