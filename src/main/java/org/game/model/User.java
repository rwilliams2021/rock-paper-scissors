package org.game.model;

import org.game.constants.Constants;
import org.game.enums.Symbol;
import org.game.utils.InputUtil;

public class User extends Player {
    
    public User() {
        name = InputUtil.getUserInput(Constants.ENTER_NAME_MSG);
    }
    
    @Override
    public Symbol chooseSymbol() {
        Symbol userSymbol = null;
        do {
            try {
                
                String userChoice = InputUtil.getUserInput(Constants.CHOOSE_SYMBOL_MSG);
                userSymbol = Symbol.fromStringSymbol(userChoice.toLowerCase());
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.INVALID_SYMBOL_MSG);
            }
        } while (userSymbol == null);
        return userSymbol;
    }
}
